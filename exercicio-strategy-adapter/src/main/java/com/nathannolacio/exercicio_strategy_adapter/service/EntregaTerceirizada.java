package com.nathannolacio.exercicio_strategy_adapter.service;

import org.springframework.stereotype.Component;

@Component
public class EntregaTerceirizada implements EntregaStrategy {

    @Override
    public double calcular(double peso) {
        return peso * 1.2;
    }

    @Override
    public String modalidade() {
        return "Terceirizada";
    }
}
