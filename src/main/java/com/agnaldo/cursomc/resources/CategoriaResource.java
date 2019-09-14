package com.agnaldo.cursomc.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Categoria categoria){
		
		categoria = service.create(categoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(categoria.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable Integer id){
		
		categoria.setId(id);
		
		service.update(categoria);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
	