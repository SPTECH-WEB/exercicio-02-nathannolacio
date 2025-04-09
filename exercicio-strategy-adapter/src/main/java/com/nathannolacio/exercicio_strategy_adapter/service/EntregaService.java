package com.nathannolacio.exercicio_strategy_adapter.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {

    private final List<EntregaStrategy> strategies;

    public EntregaService(List<EntregaStrategy> strategies) {
        this.strategies = strategies;
    }

    public double calcular(String modalidade, double peso) {
        return strategies.stream()
                .filter(s -> s.modalidade().equalsIgnoreCase(modalidade))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo de entrega inválido!"))
                .calcular(peso);
    }

    public void entregar() {
        System.out.println("Entrega interna realizada!");
    }
}