package com.dummy.api.exceptions;

import com.dummy.api.models.Pokemon;

public class PokemonAlreadyExistsException extends RuntimeException{
    public PokemonAlreadyExistsException(Long id, String name){
        super("The pokemon " + name + " with ID " + id + " already exists.");
    }
}
