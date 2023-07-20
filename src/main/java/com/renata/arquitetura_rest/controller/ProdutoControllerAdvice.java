package com.renata.arquitetura_rest.controller;

import com.renata.arquitetura_rest.exception.ProductNullException;
import com.renata.arquitetura_rest.exception.ProductPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<Object> capturaErroNull(){
        Map<String, String> body = new HashMap<String, String>();
        body.put("message", "Verifique os campos do produto");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<Object> capturaErroPreco(){
        Map<String, String> body = new HashMap<String, String>();
        body.put("message", "Verifique o preco do produto");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> erro(){
        Map<String, String> body = new HashMap<String, String>();
        body.put("message", "Ocorreu um erro generico");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
