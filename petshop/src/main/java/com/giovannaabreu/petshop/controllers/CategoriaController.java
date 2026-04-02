package com.giovannaabreu.petshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.giovannaabreu.petshop.entities.Categoria;
import com.giovannaabreu.petshop.services.CategoriaService;

@RestController
@RequestMapping("/api/categorias") // Define a rota base mencionada na segurança 
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listarTodas() {
        return categoriaService.buscarTodas();
    }

    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria) {
    
        return categoriaService.salvar(categoria);
    }
        
        @DeleteMapping("/{id}")
        public void deletar(@PathVariable Integer id) {
            categoriaService.deletar(id);
        }
            @PutMapping("/{id}")
            public Categoria atualizar(@PathVariable Integer id, @RequestBody Categoria categoria) {
                categoria.setId_categoria(id);
                return categoriaService.salvar(categoria);
            }
        
    }