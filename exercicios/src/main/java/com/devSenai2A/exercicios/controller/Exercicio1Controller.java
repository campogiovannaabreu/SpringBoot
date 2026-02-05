package com.devSenai2A.exercicios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercicio1Controller {

    @GetMapping("/idade")
    public String converterIdade(@RequestParam int anos) {

        if (anos < 0) {
            return "A idade não pode ser negativa";
        }

        if (anos > 120) {
            return "A idade não pode ser maior que 120 anos";
        }

        int meses = anos * 12;
        int dias = anos * 365;

        String status;
        if (anos < 18) {
            status = "Menor de idade";
        } else {
            status = "Maior de idade";
        }

        return "Idade em anos: " + anos +
               "\nIdade em meses: " + meses +
               "\nIdade em dias: " + dias +
               "\nStatus: " + status;
    }
}