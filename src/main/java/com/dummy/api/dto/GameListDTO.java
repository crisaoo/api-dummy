package com.dummy.api.dto;

import org.springframework.beans.BeanUtils;

import com.dummy.api.entities.GameList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO(GameList list){
        BeanUtils.copyProperties(list, this);
    }
}
