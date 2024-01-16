package com.dummy.api.infra;

import com.dummy.api.exceptions.PokemonAlreadyExistsException;
import com.dummy.api.exceptions.PokemonNotFoundException;
import com.dummy.api.exceptions.TypeNonExistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class PokemonExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PokemonNotFoundException.class)
    private ResponseEntity<ExceptionBodyResponse> pokemonNotFoundHandler(PokemonNotFoundException exception){
        ExceptionBodyResponse body = new ExceptionBodyResponse(HttpStatus.NOT_FOUND, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(body.getStatus()).body(body);
    }

    @ExceptionHandler(TypeNonExistentException.class)
    private ResponseEntity<ExceptionBodyResponse> typeNonExistentHandler(TypeNonExistentException exception){
        ExceptionBodyResponse body = new ExceptionBodyResponse(HttpStatus.NOT_FOUND, exception.getMessage(),LocalDateTime.now());
        return ResponseEntity.status(body.getStatus()).body(body);
    }

    @ExceptionHandler(PokemonAlreadyExistsException.class)
    private ResponseEntity<ExceptionBodyResponse> pokemonAlreadyExistsHandler(PokemonAlreadyExistsException exception){
        ExceptionBodyResponse body = new ExceptionBodyResponse(HttpStatus.CONFLICT, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(body.getStatus()).body(body);
    }
}