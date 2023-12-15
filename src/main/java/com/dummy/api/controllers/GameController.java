package com.dummy.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.api.dto.GameDTO;
import com.dummy.api.dto.GameMinDTO;
import com.dummy.api.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService service;

    @GetMapping 
    @Transactional(readOnly = true)
    public List<GameMinDTO> getGames(){
        return service.findAll();
    } 

    @GetMapping(value = "/{id}")
    @Transactional(readOnly = true)
    public GameDTO getGame(@PathVariable Long id){
        return service.findByID(id);
    }
}
