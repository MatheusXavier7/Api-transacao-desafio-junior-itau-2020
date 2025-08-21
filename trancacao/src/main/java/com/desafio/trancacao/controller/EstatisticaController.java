package com.desafio.trancacao.controller;

import com.desafio.trancacao.model.dto.EstatisticaDTO;
import com.desafio.trancacao.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaService estatisticaService;

    @GetMapping
    public EstatisticaDTO estatistica(
            @RequestParam(value = "segundos", required = false, defaultValue = "60") Integer segundos){
        return estatisticaService.createEstatistica(segundos);
    }
}

