package com.giovannaabreu.petshop.services;

import com.giovannaabreu.petshop.entities.Categoria;
import com.giovannaabreu.petshop.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Método para buscar todas as categorias no banco
    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAll();
    }

    // Método para salvar uma nova categoria
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}