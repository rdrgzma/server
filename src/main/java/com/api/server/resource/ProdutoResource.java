package com.api.server.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.server.model.Estabelecimento;
import com.api.server.model.Produto;
import com.api.server.repository.EstabelecimentoRepository;
import com.api.server.repository.ProdutoRepository;

@RestController
@RequestMapping(path="/produto")
public class ProdutoResource {
		@Autowired
		 private ProdutoRepository repository;
		@Autowired
		private EstabelecimentoRepository estabelecimentoRepository;
		 
		 @GetMapping(produces = "application/json")
		 @ResponseBody
		 public List<Produto> buscarTodos() {
			return this.repository.findAll();
		 }
		 
		 @PostMapping(produces="application/json")
		 @ResponseBody
		 public void criarNovo(@RequestParam(value="idestabelecimento", required=false)long idEstabelecimento, @RequestBody Produto produto) {
			 
			 Estabelecimento estabe = this.estabelecimentoRepository.findById(idEstabelecimento);
			 
			 produto.setEstabelecimento(estabe);
			 
			 this.repository.saveAndFlush(produto);
		 }
		 
		


}
