package com.agnaldo.cursomc.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agnaldo.cursomc.domain.Cliente;
import com.agnaldo.cursomc.services.ClienteServico;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteServico service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {

		List<Cliente> clientes = service.listar();

		return ResponseEntity.ok().body(clientes);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {

		Cliente Cliente = service.findById(id);

		return ResponseEntity.ok().body(Cliente);

	}

}
