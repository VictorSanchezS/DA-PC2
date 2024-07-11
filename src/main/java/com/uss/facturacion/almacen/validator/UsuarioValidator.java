package com.uss.facturacion.almacen.validator;

import com.uss.facturacion.almacen.entity.Usuario;
import com.uss.facturacion.almacen.exception.ValidateServiceException;

public class UsuarioValidator {
	public static void save (Usuario usuario) {
		if(usuario.getEmail()==null || usuario.getEmail().trim().isEmpty()) {
			throw new ValidateServiceException("El email es requerido");
		}
		if(usuario.getPassword()==null || usuario.getPassword().trim().isEmpty()) {
			throw new ValidateServiceException("El password es requerido");
		}
		
	}

}
