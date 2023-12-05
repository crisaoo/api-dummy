package com.dummy.api.dto;

import com.dummy.api.entities.Game;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class GameDTO{
    private final Long id;
    private final String title ;
    private final Integer year ;
    private final String genre;
    private final String shortDescription;
    

    public GameDTO(Game game){
        id = game.getId();
        title = game.getTitle();
        year = game.getYear();
        genre = game.getGenre();
        shortDescription = game.getShortDescription();  
    }
}