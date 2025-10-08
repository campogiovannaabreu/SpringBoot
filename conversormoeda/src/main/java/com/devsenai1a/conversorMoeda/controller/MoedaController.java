package com.devsenai1a.conversorMoeda.controller;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoedaController {

    @GetMapping("/real-dolar")
    public double realDolar(@RequestParam double a) {
        return a * 0.19;
    }

    @PostMapping("/calcular")
    @ResponseBody
    public Map<String, Object> calcularJson(
            @RequestParam double num1,
            @RequestParam String convertor,
            @RequestParam String conversao) {

        double resultado = 0;
        String erro = null;

        switch(conversao) {
            case "real":
                if(convertor.equals("dolar1")) {
                    resultado = num1 * 0.19;
                } else if(convertor.equals("euro1")) {
                    resultado = num1 * 0.16;
                }
                break;

            case "dolar":
                if(convertor.equals("real1")) {
                    resultado = num1 * 5.36;
                } else if(convertor.equals("euro1")) {
                    resultado = num1 * 0.86;
                }
                break;

            case "euro":
                if(convertor.equals("real1")) {
                    resultado = num1 * 6.23;
                } else if(convertor.equals("dolar1")) {
                    resultado = num1 * 1.16;
                }
                break;

            default:
                erro = "Operação Inválida";
                break;
        }

        Map<String, Object> resp = new HashMap<>();
        resp.put("resultado", resultado);
        resp.put("erro", erro);
        return resp;
    }
}