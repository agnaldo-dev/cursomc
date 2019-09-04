package com.agnaldo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agnaldo.cursomc.domain.Categoria;
import com.agnaldo.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {

		Optional<Categoria> obj = repository.findById(id);
	
		return obj.orElse(null);
	
	}

}
