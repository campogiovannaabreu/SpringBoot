package com.devSenai2A.exercicios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercicio3Controller {

    @GetMapping("/aluno")
    public String avaliarAluno(
            @RequestParam String nome,
            @RequestParam double n1,
            @RequestParam double n2,
            @RequestParam double n3,
            @RequestParam double n4) {

        if (n1 < 0 || n1 > 10 ||
            n2 < 0 || n2 > 10 ||
            n3 < 0 || n3 > 10 ||
            n4 < 0 || n4 > 10) {

            return "As notas devem estar entre 0 e 10";
        }

        double media = (n1 + n2 + n3 + n4) / 4;

        String situacao;
        if (media >= 7) {
            situacao = "Aprovado";
        } else if (media >= 5) {
            situacao = "Recuperação";
        } else {
            situacao = "Reprovado";
        }

        return "Aluno: " + nome +
               "\nNotas: " + n1 + ", " + n2 + ", " + n3 + ", " + n4 +
               "\nMédia: " + media +
               "\nSituação: " + situacao;
    }
}