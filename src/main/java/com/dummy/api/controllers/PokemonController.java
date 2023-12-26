package com.dummy.api.controllers;

import com.dummy.api.dto.PokemonDTO;
import com.dummy.api.services.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pokemons")
public class PokemonController {
    private final PokemonService service;

    @GetMapping
    public List<PokemonDTO> findAll(){
        List<PokemonDTO> list = service.findAll();
        return list;
    }
}
