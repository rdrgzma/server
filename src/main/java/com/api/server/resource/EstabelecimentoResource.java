package com.api.server.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.server.model.Estabelecimento;
import com.api.server.model.Produto;
import com.api.server.repository.EstabelecimentoRepository;
import com.api.server.repository.ProdutoRepository;

@RestController
@RequestMapping(path="/estabelecimento")
public class EstabelecimentoResource {
	@Autowired
	 private EstabelecimentoRepository repository;
	@Autowired
	private ProdutoRepository produtoRepository;
	 
	 @GetMapping(produces = "application/json")
	 @ResponseBody
	 public List<Estabelecimento> buscarTodos() {
		return this.repository.findAll();
	 }
	 
	 @GetMapping(value = "/{id}")
	 public Estabelecimento buscarPorId(@PathVariable(value = "id") Long id) {
		 return this.repository.findById(id);
	 }
	 
	 @PostMapping(produces="application/json")
	 @ResponseBody
	 public Estabelecimento criarNovo(@RequestBody Estabelecimento estabelecimento) {
		 return this.repository.saveAndFlush(estabelecimento);
	 }
	 
	 @GetMapping(value="/{id}/produtos")
	 @ResponseBody
	 public List<Produto> buscarPorEstabelecimento(@PathVariable(value = "id") Long id) {
		 return produtoRepository.findByEstabelecimento_id(id);
	 }

}
