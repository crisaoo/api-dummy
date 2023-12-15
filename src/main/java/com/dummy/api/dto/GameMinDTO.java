package com.dummy.api.dto;

import org.springframework.beans.BeanUtils;

import com.dummy.api.entities.Game;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class GameMinDTO{
    private Long id;
    private String title ;
    private Integer year ;
    private String genre;
    private String shortDescription;
    
    public GameMinDTO(Game game){
        BeanUtils.copyProperties(game, this);
    }
}