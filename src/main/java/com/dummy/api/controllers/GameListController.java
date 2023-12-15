package com.dummy.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.api.dto.GameListDTO;
import com.dummy.api.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService service;

    @GetMapping
    @Transactional(readOnly = true)
    public List<GameListDTO> getLists(){
        List<GameListDTO> lists = service.findAll();
        return lists;
    }

    @GetMapping(value = "/{id}")
    @Transactional(readOnly = true)
    public GameListDTO getList(@PathVariable Long id){
        GameListDTO gameList = service.findById(id);
        return gameList;
    }
}
