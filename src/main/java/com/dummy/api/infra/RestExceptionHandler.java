package com.dummy.api.infra;

import com.dummy.api.exceptions.PokemonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PokemonNotFoundException.class)
    private ResponseEntity<RestExceptionBody> TypeNonExistentHandler(PokemonNotFoundException exception){
        RestExceptionBody body = new RestExceptionBody(HttpStatus.NOT_FOUND, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(body.getStatus()).body(body);
    }
}