package com.demo.test.respositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.test.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
	public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}
