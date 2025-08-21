package com.desafio.trancacao.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public class TransacaoDTO {
    private double valor;
    private OffsetDateTime dataHora;

    @JsonCreator
    public TransacaoDTO(
            @JsonProperty("valor") Double valor,
            @JsonProperty("dataHora") OffsetDateTime dataHora) {

        if (valor == null) {
            throw new IllegalArgumentException("O campo 'valor' não pode ser nulo.");
        }
        if (dataHora == null) {
            throw new IllegalArgumentException("O campo 'dataHora' não pode ser nulo.");
        }
        if (valor < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo.");
        }
        if (dataHora.isBefore(OffsetDateTime.now())) {
            throw new IllegalArgumentException("A dataHora não pode ser no passado.");
        }
        this.valor = valor;
        this.dataHora = dataHora;
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
