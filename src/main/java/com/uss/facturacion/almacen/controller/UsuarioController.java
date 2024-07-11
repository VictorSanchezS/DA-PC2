/*package com.uss.facturacion.almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uss.facturacion.almacen.converter.UsuarioConverter;
import com.uss.facturacion.almacen.dto.UsuarioDto;
import com.uss.facturacion.almacen.entity.Usuario;
import com.uss.facturacion.almacen.service.UsuarioService;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios") //www.localhost:8081/api/usuarios
public class UsuarioController {
	@Autowired
	private UsuarioService service;
	@Autowired
	private UsuarioConverter converter;
	
	@GetMapping()
	public ResponseEntity<List<UsuarioDto>> getAll(){
		List<Usuario> usuarios= service.findAll();
		List<UsuarioDto> usuariosDto= converter.fromEntity(usuarios);
		return ResponseEntity.status(HttpStatus.OK).body(usuariosDto);
	}
	
	/*@GetMapping(value="/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable("id") int id) {
		Usuario usuario = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	*/
	/*@PostMapping
	public ResponseEntity<UsuarioDto> create(@RequestBody Usuario usuario) {
		Usuario usuarioDb=service.create(usuario);
		UsuarioDto usuarioDto=converter.fromEntity(usuarioDb);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
	}*/
	/*
	@PutMapping
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
		Usuario usuarioDb=service.update(usuario);
		return ResponseEntity.status(HttpStatus.OK).body(usuarioDb);
	}
	
}
*/