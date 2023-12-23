package com.dummy.api.services;

import java.util.List;
import java.util.Optional;

import com.dummy.api.dto.GameMinDTO;
import com.dummy.api.entities.Game;
import com.dummy.api.projections.GameMinProjection;
import com.dummy.api.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dummy.api.dto.GameListDTO;
import com.dummy.api.entities.GameList;
import com.dummy.api.repository.GameListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameListService {
    private final GameListRepository repository;
    private final GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> gameLists = repository.findAll();
        return gameLists.stream().map(GameListDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id){
        GameList gameList = repository.findById(id).get();
        return new GameListDTO(gameList);
    }

    @Transactional
    public void movePosition(long listId, int sourcePos, int targetPos){
        List<GameMinProjection> gamesByList = gameRepository.searchByList(listId);

        GameMinProjection game = gamesByList.remove(sourcePos);
        gamesByList.add(targetPos, game);

        int max = Math.max(sourcePos, targetPos);
        int min = Math.min(sourcePos, targetPos);

        for(int i=min; i <= max; i++)
            repository.updateBelongingPosition(listId, gamesByList.get(i).getId(), i);
    }
}
