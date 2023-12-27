package com.dummy.api.controllers;

import com.dummy.api.entities.Pokeball;
import com.dummy.api.services.PokeballService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pokeballs")
public class PokeballController {
    private final PokeballService service;

    @GetMapping
    public List<Pokeball> findAll(){
        List<Pokeball> list = service.findAll();
        return list;
    }
}
