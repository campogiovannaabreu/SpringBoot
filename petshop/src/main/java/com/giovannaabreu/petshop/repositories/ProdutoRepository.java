package com.giovannaabreu.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giovannaabreu.petshop.entities.Produto.Produtos;

public class ProdutoRepository {

	public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {
	    
	    Produtos findByNome (String nome);

	}
}
