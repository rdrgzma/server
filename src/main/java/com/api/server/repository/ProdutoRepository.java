package com.api.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.server.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findByEstabelecimento_id(Long id);

}
