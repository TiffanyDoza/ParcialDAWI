package com.redsocial.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.redsocial.entidad.Editorial;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {

	@Query( "select p from Editorial p where p.nombre like :param")
	public abstract List<Editorial>  listaPorNombre(@Param("param") String filtro);
}
