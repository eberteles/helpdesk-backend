package com.eber.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eber.helpdesk.domain.Chamado;
import com.eber.helpdesk.repositories.ChamadoRepository;
import com.eber.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow( () -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id) );
	}

}
