package com.eber.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eber.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
