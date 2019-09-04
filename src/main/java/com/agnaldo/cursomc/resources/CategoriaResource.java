package com.agnaldo.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agnaldo.cursomc.domain.Categoria;
import com.agnaldo.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {

		Categoria c1 = new Categoria(1, "Informatica");
		Categoria c2 = new Categoria(2, "Escritorio");

		List<Categoria> lista = new ArrayList<Categoria>();
		lista.add(c1);
		lista.add(c2);

		return lista;
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
        
		Categoria categoria = service.findById(id);
        
        return ResponseEntity.ok().body(categoria);
	
	}

	
}
