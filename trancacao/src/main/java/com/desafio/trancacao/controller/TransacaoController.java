package com.desafio.trancacao.controller;

import com.desafio.trancacao.model.dto.TransacaoDTO;
import com.desafio.trancacao.service.TransacaoService;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;


@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação gravada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Campos não atendem os requisitos da transação"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")})
    public ResponseEntity<Void> salvarTransacao(@RequestBody TransacaoDTO transacaoDTO) {
        transacaoService.create(transacaoDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/")
        public List<TransacaoDTO> listarTransacao() {
        return transacaoService.getListaTransacoes();
    }

    @DeleteMapping("/")
    public void excluirTransacao() {
        transacaoService.delete();
    }

}
