/*package com.uss.facturacion.almacen.converter;

import org.springframework.stereotype.Component;

import com.uss.facturacion.almacen.dto.UsuarioDto;
import com.uss.facturacion.almacen.entity.Usuario;

@Component
public class UsuarioConverter extends AbstractConverter<Usuario, UsuarioDto>{

	@Override
	public UsuarioDto fromEntity(Usuario entity) {
		if(entity == null) return null;
		return UsuarioDto.builder()
				.id(entity.getId())
				.email(entity.getEmail())
				.activo(entity.getActivo())
				.build();
	}

	@Override
	public Usuario fromDTO(UsuarioDto dto) {
		if(dto==null) return null;
		
		/*Usuario usuario = new Usuario();
		usuario.setId(dto.getId());
		usuario.setEmail(dto.getEmail());
		return usuario;*/
		/*
		return Usuario.builder()
				.id(dto.getId())
				.email(dto.getEmail())
				.build();
	}

	

}
*/