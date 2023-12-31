package com.dummy.api.controller;

import com.dummy.api.model.records.PokemonDTO;
import com.dummy.api.model.records.PokemonListDTO;
import com.dummy.api.service.PokemonService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pokemons")
public class PokemonController {
    private final PokemonService service;

    @GetMapping
    public List<PokemonListDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PokemonDTO findById(@PathVariable Long id){
        return service.findById(id);
     }

    @GetMapping("/{id}/counters")
    public List<PokemonListDTO> findCounterPokemons(@PathVariable Long id){
        // TODO: return a response entity with a header to indicate the weak types?
        return service.findCounterPokemons(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
