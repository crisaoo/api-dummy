package com.dummy.api.dto;

import org.springframework.beans.BeanUtils;

import com.dummy.api.entities.Game;
import com.dummy.api.projections.GameMinProjection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class GameMinDTO{
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;
    
    public GameMinDTO(Game game){
        BeanUtils.copyProperties(game, this);
    }

    public GameMinDTO(GameMinProjection gameMinProjection){
        BeanUtils.copyProperties(gameMinProjection, this);
        this.year = gameMinProjection.getGameYear();
    }
}