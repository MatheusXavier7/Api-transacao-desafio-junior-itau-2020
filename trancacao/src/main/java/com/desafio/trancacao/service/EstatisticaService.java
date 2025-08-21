package com.desafio.trancacao.service;

import com.desafio.trancacao.model.dto.EstatisticaDTO;
import com.desafio.trancacao.model.dto.TransacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstatisticaService {

    @Autowired
    private TransacaoService transacaoService;

    public EstatisticaDTO createEstatistica(Integer tempo) {
        List<TransacaoDTO> transacoes = transacaoService.getTransacao(tempo);
        DoubleSummaryStatistics statistics = transacoes.stream()
                .collect(Collectors.summarizingDouble(TransacaoDTO::getValor));
        return new EstatisticaDTO(statistics.getCount(), statistics.getSum(),
                statistics.getAverage(), statistics.getMin(), statistics.getMax());
    }
}
