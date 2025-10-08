package com.devsenai1a.temperatura.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorController {
    @PostMapping ("/converter")
    @ResponseBody
    public Map<String, Object> converterJson(
            @RequestParam double num1,
            @RequestParam String inicio,
            @RequestParam String fim){
        
                double resultado=0;
                String erro = null;
                
                switch(inicio) {
                case "Fahrenheit":
                    if(fim.equals("Celsius1"))
                        resultado = (num1 - 32) * 5/9;
                    else if (fim.equals("Kelvin1")) 
                        resultado = (num1 - 32) * 5/9 + 273.15; 
                    break;
                case "Celsius":
                    if(fim.equals("Farenheit1"))
                        resultado = (num1 * 1.8) + 32;
                     else if (fim.equals ("Kelvin1")) 
                         resultado = num1 + 273.15; break;
                case "Kelvin":
                    if(fim.equals("Farenheit1"))
                        resultado = (num1 - 273.15) * 1.8 + 32;
                    else if (fim.equals ("Celsius1"))
                        resultado = num1 - 273.15; break;
                default: erro = "Conversão inválida!";
                }
                
                Map<String, Object> resp = new HashMap<>();
                resp.put("resultado", resultado);
                resp.put("erro", erro);
                return resp;
    }
}