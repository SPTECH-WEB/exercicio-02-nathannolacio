package com.nathannolacio.exercicio_strategy_adapter.service;

import org.springframework.stereotype.Component;

@Component
public class EntregaEconomica implements EntregaStrategy{

    @Override
    public double calcular(double peso) {
        return peso * 0.5;
    }

    @Override
    public String modalidade() {
        return "Econômica";
    }
}
