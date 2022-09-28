package com.Recirende.Fidelidade.Exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.rmi.NoSuchObjectException;
import java.rmi.ServerException;
import java.util.NoSuchElementException;

public class ExceptionHandlerUsuario {

    @ExceptionHandler({DuplicateKeyException.class})
    public ResponseEntity<String> usuarioExistente(DuplicateKeyException noUniqueBeanDefinitionException, HttpServletRequest httpServletRequest){
        return new ResponseEntity<>("Usuario já cadastrado", HttpStatus.FORBIDDEN);


    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> formatoNaoPermitido(ConstraintViolationException invalidFormatException, HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>("Formatação invalida! Revise os campos...", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> objetoInexistente(NoSuchElementException noSuchObjectException, HttpServletRequest httpServletRequest){
        return new ResponseEntity<>("Objeto não encontrado", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<String> ListaVazia(ServerException serverException, HttpServletRequest httpServletRequest){
        return new ResponseEntity<>("Sua lista esta vazia", HttpStatus.NO_CONTENT);
    }

}
