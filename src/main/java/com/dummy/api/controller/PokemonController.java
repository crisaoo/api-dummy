package com.dummy.api.controller;

import com.dummy.api.model.Pokemon;
import com.dummy.api.model.records.PokemonDTO;
import com.dummy.api.model.records.PokemonInsert;
import com.dummy.api.model.records.PokemonList;
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
    public List<PokemonList> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PokemonDTO findById(@PathVariable Long id){
        return service.findById(id);
     }

    @GetMapping("/{id}/counters")
    public List<PokemonList> findCounterPokemons(@PathVariable Long id){
        return service.findCounterPokemons(id);
    }

    @GetMapping("/types/{type}")
    public List<PokemonList> findByType(@PathVariable String type){
        return service.findByType(type);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Pokemon create(@RequestBody PokemonInsert obj){
        return service.create(obj);
    }

    // TODO: create a put request to update a pokemon evolution
}
