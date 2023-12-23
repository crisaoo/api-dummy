package com.dummy.api.controllers;

import java.util.List;

import com.dummy.api.dto.ReplacementDTO;

import com.dummy.api.dto.GameListDTO;
import com.dummy.api.dto.GameMinDTO;
import com.dummy.api.services.GameListService;
import com.dummy.api.services.GameService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/lists")
public class GameListController {
    private final GameListService service;
    private final GameService gameService;

    @GetMapping
    public List<GameListDTO> getLists(){
        List<GameListDTO> lists = service.findAll();
        return lists;
    }

    @GetMapping(value = "/{id}")
    public GameListDTO getList(@PathVariable Long id){
        GameListDTO gameList = service.findById(id);
        return gameList;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> getGamesByList(@PathVariable Long listId){
        List<GameMinDTO> gameList = gameService.findByList(listId);
        return gameList;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        Integer sourcePos = body.getSourcePosition();
        Integer targetPos = body.getTargetPosition();
        service.movePosition(listId, sourcePos, targetPos);
    }
}
