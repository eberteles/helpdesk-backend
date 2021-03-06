package com.eber.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eber.helpdesk.domain.Chamado;
import com.eber.helpdesk.domain.Cliente;
import com.eber.helpdesk.domain.Tecnico;
import com.eber.helpdesk.domain.enums.Perfil;
import com.eber.helpdesk.domain.enums.Prioridade;
import com.eber.helpdesk.domain.enums.Status;
import com.eber.helpdesk.repositories.ChamadoRepository;
import com.eber.helpdesk.repositories.ClienteRepository;
import com.eber.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	public void instanciaDB( ) {
		Tecnico tec1	= new Tecnico(null, "Eber Teles", "72087340110", "eberteles@hotmail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		
		Tecnico tec2	= new Tecnico(null, "Rodrigo Caio", "78306447050", "rodrigocaio@hotmail.com", encoder.encode("123"));
		tec2.addPerfil(Perfil.ADMIN);

		
		Cliente cli1	= new Cliente(null, "Linus Torvalds", "70511744013", "torvalds@gmail.com", encoder.encode("123"));
		
		Chamado c1		= new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
