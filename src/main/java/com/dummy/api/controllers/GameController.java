package com.dummy.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.api.dto.GameDTO;
import com.dummy.api.dto.GameMinDTO;
import com.dummy.api.services.GameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/games")
public class GameController {
    private final GameService service;

    @GetMapping 
    public List<GameMinDTO> getGames(){
        return service.findAll();
    } 

    @GetMapping(value = "/{id}")
    public GameDTO getGame(@PathVariable Long id){
        return service.findByID(id);
    }
}
