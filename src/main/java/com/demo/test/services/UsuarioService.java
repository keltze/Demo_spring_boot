package com.demo.test.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.test.models.UsuarioModel;
import com.demo.test.respositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public ArrayList<UsuarioModel> getAllUsuarios() {
		return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
	}
	
	public UsuarioModel saveUsuario(UsuarioModel usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<UsuarioModel> getUsuarioById(Long id){
		return usuarioRepository.findById(id);
	}
	
	public ArrayList<UsuarioModel> getUserByPrioridad(Integer prioridad){
		return usuarioRepository.findByPrioridad(prioridad);
	}
	
	public boolean deleteUsuarioById(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
