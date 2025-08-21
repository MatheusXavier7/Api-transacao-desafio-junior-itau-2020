package com.desafio.trancacao.model.dto;

import java.time.OffsetDateTime;

public class TransacaoDTO {
    private double valor;
    private OffsetDateTime dataHora;

    TransacaoDTO(double valor, OffsetDateTime dataHora) {
        if(valor >=0 ) {
            this.valor = valor;
        }
        if(dataHora.isBefore(OffsetDateTime.now())) {
            this.dataHora = dataHora;
        }
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
