package com.dummy.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.api.repository.GameRepository;
import com.dummy.api.dto.GameDTO;
import com.dummy.api.dto.GameMinDTO;
import com.dummy.api.entities.Game;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public List<GameMinDTO> findAll(){
        List<Game> games = repository.findAll();
        List<GameMinDTO> gamesDTO = games.stream().map(game -> new GameMinDTO(game)).toList();
        return gamesDTO;
    }

    public GameDTO findByID(Long id){
        Game game = repository.findById(id).get();
        GameDTO gameDTO = new GameDTO(game);
        return gameDTO;
    }
}
