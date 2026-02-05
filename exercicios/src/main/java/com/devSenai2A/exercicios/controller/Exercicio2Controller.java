package com.devSenai2A.exercicios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercicio2Controller {

    @GetMapping("/desconto")
    public String calcularDesconto(
            @RequestParam double valor,
            @RequestParam double percentual) {

        if (valor <= 0) {
            return "O valor do produto deve ser maior que zero";
        }

        if (percentual < 0 || percentual > 50) {
            return "O desconto deve estar entre 0% e 50%";
        }

        double valorDesconto = valor * (percentual / 100);
        double valorFinal = valor - valorDesconto;

        String resposta = "Valor original: " + valor +
                          "\nDesconto: " + valorDesconto +
                          "\nValor final: " + valorFinal;

        if (percentual > 30) {
            resposta += "\nDesconto especial aplicado";
        }

        return resposta;
    }
}