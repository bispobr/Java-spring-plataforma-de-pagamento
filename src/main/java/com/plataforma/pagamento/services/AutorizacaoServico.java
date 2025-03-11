package com.plataforma.pagamento.services;


import com.plataforma.pagamento.domain.user.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class AutorizacaoServico {



    @Autowired
    private RestTemplate restTemplate;

    public boolean autorizacaoTransacao(Usuario remetente, BigDecimal valor ){
        ResponseEntity<Map> autorizacaoResposta = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize",Map.class);

        if (autorizacaoResposta.getStatusCode() == HttpStatus.OK && autorizacaoResposta.getBody().get("message") == "Autorizado"){
            return true;
        } else return false;

    }
}
