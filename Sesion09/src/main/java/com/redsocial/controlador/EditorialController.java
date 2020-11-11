package com.redsocial.controlador;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redsocial.entidad.Editorial;
import com.redsocial.entidad.Pais;
import com.redsocial.servicio.EditorialService;
import com.redsocial.servicio.PaisService;

@Controller
public class EditorialController {

	@Autowired
	private EditorialService editorialService;
	
	@Autowired
	private PaisService paisService;
	
	@RequestMapping("/")
	public String verCrud() {
		return "crudEditorial";
	}
	
	@RequestMapping("/cargaPais")
	@ResponseBody
	public List<Pais> listaPais() {
		return paisService.listarTodos();
	}
	
	@RequestMapping("/consultaCrudEditorial")
	public String lista(String filtro, HttpSession session) {
		List<Editorial> lista =  editorialService.listarPorNombre(filtro+"%");
		session.setAttribute("editoriales", lista);
		return "crudEditorial";
	}
	
	@RequestMapping("/registraActualizaCrudEditorial")
	public String registraActualiza(Editorial obj, HttpSession session) {
		
		try {
			Editorial sal = editorialService.insertaActualizaEditorial(obj);
			if(sal == null) {
				session.setAttribute("MENSAJE", "Existe ERROR");
			}else {
				session.setAttribute("MENSAJE", "Se registra o actualiza correctamente");
			}
		} catch (Exception e) {
			session.setAttribute("MENSAJE", "Existe ERROR");
			e.printStackTrace();
		}
		return "redirect:salida";
	}
	
	@RequestMapping("/eliminaCrudEditorial")
	public String elimina(int id, HttpSession session) {
		
		try {
			Optional<Editorial> obj = editorialService.buscaPorId(id);
			if(obj.isPresent()) {
				editorialService.eliminaEditorial(id);
				session.setAttribute("MENSAJE", "Se elimina correctamente");
			}else {
				session.setAttribute("MENSAJE", "No existe el ID");	
			}	
		} catch (Exception e) {
			session.setAttribute("MENSAJE", "Existe ERROR");
			e.printStackTrace();
		}
		return "redirect:salida";
	}
	
	@RequestMapping("/salida")
	public String listarTodos(HttpSession session) {
		List<Editorial> data = editorialService.listarTodos();
		session.setAttribute("editoriales", data);
		return "crudEditorial";
	}
}
