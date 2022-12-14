package com.Recirende.Fidelidade.Exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

public class ExceptionHandlerPremios {



    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> formatoNaoPermitido(ConstraintViolationException invalidFormatException, HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>("Formatação invalida! Revise os campos...", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> objetoInexistente(NoSuchElementException noSuchObjectException, HttpServletRequest httpServletRequest){
        return new ResponseEntity<>("Objeto não encontrado", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> listaVazia(NullPointerException serverException, HttpServletRequest httpServletRequest){
        return new ResponseEntity<>("Sua lista esta vazia", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tipoNaoAceito(HttpMessageNotReadableException messageNotReadableException, HttpServletRequest httpServletRequest){
        return new ResponseEntity<>("A formatação não é aceita", HttpStatus.BAD_REQUEST);
    }
}
