package com.agnaldo.cursomc.services;

import java.util.Optional;

import javax.validation.ReportAsSingleViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agnaldo.cursomc.domain.Categoria;
import com.agnaldo.cursomc.repositories.CategoriaRepository;
import com.agnaldo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {

		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				" Objecto não encontrado Id : " + id + ", Tipo : " + Categoria.class.getName()));
	}

	public Categoria create(Categoria categoria) {
        
		categoria.setId(null);

		return repository.save(categoria);
	
	}
	
	public Categoria update(Categoria categoria) {
	    
		findById(categoria.getId());
	    
		return repository.save(categoria);
	
	}
	

}
