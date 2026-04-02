package com.giovannaabreu.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovannaabreu.petshop.entities.Categoria;
import com.giovannaabreu.petshop.repositories.CategoriaRepository;

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
        
        public void deletar(Integer id) {
            categoriaRepository.deleteById(id);
        }
            
            public Categoria atualizar(Integer id, Categoria categoria) {
                if (!categoriaRepository.existsById(id)) {
                    throw new RuntimeException("Categoria não encontrada");
                }
                categoria.setId_categoria(id);
                return categoriaRepository.save(categoria);
            }
        
    }