package com.uss.facturacion.almacen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uss.facturacion.almacen.entity.Usuario;
import com.uss.facturacion.almacen.entity.Usuario;
//import com.uss.facturacion.almacen.entity.Usuario;
import com.uss.facturacion.almacen.exception.GeneralServiceException;
import com.uss.facturacion.almacen.exception.ValidateServiceException;
import com.uss.facturacion.almacen.repository.UsuarioRepository;
import com.uss.facturacion.almacen.service.UsuarioService;
import com.uss.facturacion.almacen.validator.UsuarioValidator;
//import com.uss.facturacion.almacen.validator.UsuarioValidator;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		try {
			return repository.findAll();		
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(int id) {
		try {
	        Usuario usuarioDb = repository.findById(id)
	                .orElseThrow(() -> new ValidateServiceException("No hay un registro con ese ID"));
	        
	        return usuarioDb;
	        
	    } catch (ValidateServiceException e) {
	        throw e; 	                 
	    } catch (Exception e) {
	        throw new GeneralServiceException("Error en el servidor");
	    }
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByEmail(String email) {
		try {
			return repository.findByEmail(email);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public Usuario create(Usuario obj) {
		try {
			UsuarioValidator.save(obj);
			Usuario usuario=findByEmail(obj.getEmail());
			if(usuario!=null) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			obj.setActivo(true);
			return repository.save(obj);			
		} catch (ValidateServiceException e) {
			throw new ValidateServiceException(e.getMessage());
		} catch (Exception e) {
			throw new GeneralServiceException("Error en el servidor");
		}
	}

	@Override
	@Transactional
	public Usuario update(Usuario obj) {
		try {
			UsuarioValidator.save(obj);
			Usuario usuarioDb=findById(obj.getId());
			//Validamos si ya existe el registro con ese nombre
			Usuario usuario=findByEmail(obj.getEmail());
			if(usuario!=null && obj.getId()!=usuario.getId()) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			usuarioDb.setEmail(obj.getEmail());			
			usuarioDb.setPassword(obj.getPassword());	
			//usuarioDb.setActivo(obj.getActivo());
			return repository.save(usuarioDb);
			
		} catch (ValidateServiceException e) {
			throw new ValidateServiceException(e.getMessage());
		} catch (Exception e) {
			throw new GeneralServiceException("Error en el servidor");
		}
	}

	@Override
	public int activate(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int desactivate(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
