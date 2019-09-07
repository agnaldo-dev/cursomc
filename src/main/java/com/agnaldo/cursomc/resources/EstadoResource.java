package com.agnaldo.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agnaldo.cursomc.domain.Estado;
import com.agnaldo.cursomc.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

	@Autowired
	private EstadoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		
		List<Estado> estados = service.listar();

        return ResponseEntity.ok().body(estados);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
        
		Estado estado = service.findById(id);
        
        return ResponseEntity.ok().body(estado);
	
	}

	
}
