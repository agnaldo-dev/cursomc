package com.agnaldo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agnaldo.cursomc.domain.Estado;
import com.agnaldo.cursomc.repositories.EstadoRepository;
import com.agnaldo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	public List<Estado> listar() {

		List<Estado> obj = repository.findAll();

		return obj;

	}

	public Estado findById(Integer id) {

		Optional<Estado> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				" Objecto não encontrado Id : " + id + ", Tipo : " + Estado.class.getName()));
	}

}
