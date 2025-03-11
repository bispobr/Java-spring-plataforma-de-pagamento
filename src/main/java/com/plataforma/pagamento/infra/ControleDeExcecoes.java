package com.plataforma.pagamento.infra;

import com.plataforma.pagamento.dtos.ExcecaoDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControleDeExcecoes {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity entradaDuplicada(DataIntegrityViolationException exception){
        ExcecaoDTO excecaoDTO =  new ExcecaoDTO("usuario ja cadastrado","400");
        return ResponseEntity.badRequest().body(excecaoDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity naoEncontrado(EntityNotFoundException exception){

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity excecoesGerais(Exception exception){
        ExcecaoDTO excecaoDTO =  new ExcecaoDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(excecaoDTO);
    }
}