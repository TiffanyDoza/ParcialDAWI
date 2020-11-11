package com.redsocial.servicio;

import java.util.List;
import java.util.Optional;

import com.redsocial.entidad.Editorial;

public interface EditorialService {

	public abstract Editorial insertaActualizaEditorial(Editorial obj);
	public abstract void eliminaEditorial(int id);
	public abstract List<Editorial> listarTodos();
	public abstract List<Editorial> listarPorNombre(String filtro);
	public abstract Optional<Editorial> buscaPorId(int id);
}
