package com.dummy.api.model.dto;

import com.dummy.api.model.Pokemon;
import com.dummy.api.model.enums.PokemonType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

import org.springframework.beans.BeanUtils;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor

public class PokemonDTO implements Serializable{
    @Serial
    private static final long serialVersionUID=1L;

    private Long id;
    private String name;
    private PokemonType types;
    private PokemonType weaknesses;
    private Long evolution;
    private Double weight;
    private Double height;

    public PokemonDTO(Pokemon obj){
        BeanUtils.copyProperties(obj, this);
    }
}
