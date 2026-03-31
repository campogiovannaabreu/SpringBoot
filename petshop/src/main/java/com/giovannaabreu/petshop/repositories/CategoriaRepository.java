package com.giovannaabreu.petshop.repositories;

	import com.giovannaabreu.petshop.entities.Categoria;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	@Repository
	public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	    // Não é necessário escrever nenhum método aqui para o básico.
	    // O JpaRepository já fornece: save(), findAll(), findById(), delete(), etc.
	}

