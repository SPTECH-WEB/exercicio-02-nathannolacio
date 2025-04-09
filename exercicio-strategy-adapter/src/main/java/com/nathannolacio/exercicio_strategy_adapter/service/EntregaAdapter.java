package com.nathannolacio.exercicio_strategy_adapter.service;

import org.springframework.stereotype.Service;

@Service("transportadora")
public class EntregaAdapter implements EntregaAdapterService {

    private final EntregaTerceirizadaAdapter entregaTerceirizadaAdapter;

    public EntregaAdapter() {
        this.entregaTerceirizadaAdapter = new EntregaTerceirizadaAdapter();
    }

    @Override
    public void entregar() {
        entregaTerceirizadaAdapter.entregarComTransportadora();
    }
}
