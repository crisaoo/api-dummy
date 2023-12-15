package com.dummy.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dummy.api.dto.GameListDTO;
import com.dummy.api.entities.GameList;
import com.dummy.api.repository.GameListRepository;

@Service
public class GameListService {
    @Autowired
    private GameListRepository repository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> gameLists = repository.findAll();
        List<GameListDTO> gameListDTO = gameLists.stream().map(list -> new GameListDTO(list)).toList();
        return gameListDTO;
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id){
       GameList gameList = repository.findById(id).get();
       GameListDTO gameListDTO = new GameListDTO(gameList);
       return gameListDTO;
    }
}
