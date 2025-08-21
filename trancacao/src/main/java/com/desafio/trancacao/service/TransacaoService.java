package com.desafio.trancacao.service;

import com.desafio.trancacao.model.dto.TransacaoDTO;
import org.springframework.boot.actuate.autoconfigure.tracing.TracingProperties;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    public List<TransacaoDTO> listaTransacoes = new ArrayList<>();

     public void create(TransacaoDTO transacao) {
        listaTransacoes.add(transacao);
     }

     public void delete(){
         listaTransacoes.clear();
     }

     public List<TransacaoDTO> getTransacao(Integer segundos){
         OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(segundos);
         return listaTransacoes.stream().filter(t -> t.getDataHora()
                 .equals(dataHoraIntervalo)).collect(Collectors.toList());
     }
}
