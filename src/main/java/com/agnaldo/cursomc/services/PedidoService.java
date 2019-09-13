package com.agnaldo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agnaldo.cursomc.domain.Pedido;
import com.agnaldo.cursomc.repositories.PedidoRepository;
import com.agnaldo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public List<Pedido> listar(){
		
	  return repository.findAll();	
	
	}
	
	public Pedido findById(Integer id) {

		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				" Objecto não encontrado Id : " + id + ", Tipo : " + Pedido.class.getName()));
	}

}
