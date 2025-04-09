package com.nathannolacio.exercicio_strategy_adapter.controller;

import com.nathannolacio.exercicio_strategy_adapter.service.EntregaAdapter;
import com.nathannolacio.exercicio_strategy_adapter.service.EntregaAdapterService;
import com.nathannolacio.exercicio_strategy_adapter.service.EntregaService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private final EntregaService entregaService;
    private final EntregaAdapterService entregaAdapterService;

    public EntregaController(EntregaService entregaService,@Qualifier("transportadora") EntregaAdapterService entregaAdapterService) {
        this.entregaService = entregaService;
        this.entregaAdapterService = entregaAdapterService;
    }


    @GetMapping
    public String calcularFreteEntrega(@RequestParam String modalidade, @RequestParam double peso) {
        double total = entregaService.calcular(modalidade, peso);
        return "Frete (" + modalidade + ") para " + peso + "Kg: R$ " + total;
    }

    @PostMapping
    public String entregar() {
        entregaAdapterService.entregar();
        return "Entrega realizada com sucesso!";
    }
}
