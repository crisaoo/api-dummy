package com.dummy.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.api.dto.GameListDTO;
import com.dummy.api.dto.GameMinDTO;
import com.dummy.api.services.GameListService;
import com.dummy.api.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService service;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> getLists(){
        List<GameListDTO> lists = service.findAll();
        return lists;
    }

    @Transactional(readOnly = true)
    public GameListDTO getList(@PathVariable Long id){
        GameListDTO gameList = service.findById(id);
        return gameList;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> getGamesByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }
}
