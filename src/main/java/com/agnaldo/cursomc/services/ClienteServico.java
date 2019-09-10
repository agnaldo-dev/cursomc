package com.agnaldo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agnaldo.cursomc.domain.Cliente;
import com.agnaldo.cursomc.repositories.ClienteRepository;
import com.agnaldo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteServico {

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> listar() {

		List<Cliente> listaClientes = repository.findAll();

		return listaClientes;

	}
	
	public Cliente findById(Integer id) {

		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				" Objecto não encontrado Id : " + id + ", Tipo : " + Cliente.class.getName()));
	}

	
}
