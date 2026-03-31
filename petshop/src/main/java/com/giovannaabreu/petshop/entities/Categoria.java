package com.giovannaabreu.petshop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria") // Nome da tabela no MySQL 
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria; // Chave primária auto-incremento [cite: 14]

    private String nome; // VARCHAR(100) NOT NULL [cite: 15]

    private String descricao; // TEXT [cite: 16]

    private Boolean ativo; // BOOLEAN DEFAULT TRUE [cite: 17]

    // Construtor padrão (obrigatório pelo JPA)
    public Categoria() {
    }

    // Getters e Setters
    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
