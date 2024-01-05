package com.dummy.api.controller;

import com.dummy.api.model.Pokeball;
import com.dummy.api.service.PokeballService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pokeballs")
@Tag(name = "Pokeball")
public class PokeballController {
    private final PokeballService service;

    @GetMapping
    @Hidden
    public List<Pokeball> findAll(){
        List<Pokeball> list = service.findAll();
        return list;
    }
}
