package com.api.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.server.model.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento,Long> {
	public Estabelecimento findById(Long id);
	

}
