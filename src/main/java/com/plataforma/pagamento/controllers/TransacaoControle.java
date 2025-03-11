package com.plataforma.pagamento.controllers;


import com.plataforma.pagamento.domain.transaction.Transacao;
import com.plataforma.pagamento.dtos.TransacaoDto;
import com.plataforma.pagamento.services.TransacaoServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransacaoControle {
    @Autowired
    private TransacaoServicos transacaoServicos;

    @PostMapping

    public ResponseEntity<Transacao> criarTransacao(@RequestBody TransacaoDto transacao) throws Exception {
        Transacao novaTransacao = this.transacaoServicos.CriarTransacao((transacao));
        return new ResponseEntity<>(novaTransacao, HttpStatus.OK);
    }

}
