package com.demo.test.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.test.models.UsuarioModel;
import com.demo.test.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ArrayList<UsuarioModel> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}
	
	@PostMapping()
	public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioService.saveUsuario(usuario);
	}
	
	@GetMapping("/{id}")
	public Optional<UsuarioModel> getUsuarioById(@PathVariable("id") Long id){
		return this.usuarioService.getUsuarioById(id);
	}
	
	@GetMapping("/query")
	public ArrayList<UsuarioModel> getUsuarioByPrioridad(@RequestParam("prioridad") Integer prioridad){
		return this.usuarioService.getUserByPrioridad(prioridad);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteUsuarioById(@PathVariable("id") Long id) {
		boolean ok = this.usuarioService.deleteUsuarioById(id);
		if(ok) {
			return "Se eliminio el usuario con id: " + id;
		}else {
			return "NO se pudo eliminar el usuario con id: " + id;
		}
	}
	
}
