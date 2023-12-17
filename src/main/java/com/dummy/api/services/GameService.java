package com.dummy.api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dummy.api.repository.GameRepository;

import lombok.RequiredArgsConstructor;

import com.dummy.api.dto.GameDTO;
import com.dummy.api.dto.GameMinDTO;
import com.dummy.api.entities.Game;
import com.dummy.api.projections.GameMinProjection;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> games = repository.findAll();
        List<GameMinDTO> gamesDTO = games.stream().map(game -> new GameMinDTO(game)).toList();
        return gamesDTO;
    }

    @Transactional(readOnly = true)
    public GameDTO findByID(Long id){
        Game game = repository.findById(id).get();
        GameDTO gameDTO = new GameDTO(game);
        return gameDTO;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listID){
        List<GameMinProjection> gameProjectionList = repository.searchByList(listID);
        List<GameMinDTO> gameMinDTOList = gameProjectionList.stream().map(gameProjection -> new GameMinDTO(gameProjection)).toList();
        return gameMinDTOList;
    }
}
