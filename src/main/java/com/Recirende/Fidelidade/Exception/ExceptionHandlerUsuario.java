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

public class ExceptionHandlerUsuario {

    @ExceptionHandler({DuplicateKeyException.class})
    public ResponseEntity<String> usuarioExistente(DuplicateKeyException noUniqueBeanDefinitionException, HttpServletRequest httpServletRequest){
        return new ResponseEntity<>("Usuario já cadastrado", HttpStatus.FORBIDDEN);


    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> formatoNaoPermitido(ConstraintViolationException invalidFormatException, HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>("Formatação invalida! Revise os campos...", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NoSuchObjectException.class)
    public ResponseEntity<String> objetoInexistente(NoSuchObjectException noSuchObjectException, HttpServletRequest httpServletRequest){
        return new ResponseEntity<>("Objeto n]ao encontrado", HttpStatus.NO_CONTENT);
    }

}
