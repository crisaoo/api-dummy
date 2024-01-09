package com.dummy.api.exceptions;

public class PokemonNotFoundException extends RuntimeException{
    public PokemonNotFoundException(Long id){
        super("Pokemon with ID " + String.valueOf(id) + " not found.");
    }

    public PokemonNotFoundException(String message){
        super(message);
    }
}
