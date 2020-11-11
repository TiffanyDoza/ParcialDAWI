package com.redsocial.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.entidad.Pais;
import com.redsocial.repositorio.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService{
	
	@Autowired
	private PaisRepository repository;

	@Override
	public List<Pais> listarTodos() {
		return repository.findAll();
	}

}
