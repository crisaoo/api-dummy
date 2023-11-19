package com.dummy.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.api.repository.GameRepository;
import com.dummy.api.dto.GameDTO;
import com.dummy.api.entities.Game;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public List<GameDTO> findAll(){
        List<Game> games = repository.findAll();
        List<GameDTO> gamesDTO = games.stream().map(game -> new GameDTO(game)).toList();
        return gamesDTO;
    }
}
