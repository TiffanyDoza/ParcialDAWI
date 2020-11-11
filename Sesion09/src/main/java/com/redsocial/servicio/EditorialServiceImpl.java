package com.redsocial.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.entidad.Editorial;

import com.redsocial.repositorio.EditorialRepository;


@Service
public class EditorialServiceImpl implements EditorialService{

	@Autowired
	private EditorialRepository repository;
	
	@Override
	public Editorial insertaActualizaEditorial(Editorial obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaEditorial(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<Editorial> listarTodos() {
		return repository.findAll();
	}

	@Override
	public List<Editorial> listarPorNombre(String filtro) {
		return repository.listaPorNombre(filtro);
	}

	@Override
	public Optional<Editorial> buscaPorId(int id) {
		return repository.findById(id);
	}

}
