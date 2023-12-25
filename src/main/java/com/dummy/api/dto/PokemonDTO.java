package com.dummy.api.dto;

import com.dummy.api.entities.Pokemon;
import com.dummy.api.enums.PokemonType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class PokemonDTO {
    private Long id;
    private String name;
    private PokemonType types;
    private PokemonType weaknesses;
    private Pokemon evolution;
    private Double weight;
    private Double height;

    public PokemonDTO(Pokemon obj){
        BeanUtils.copyProperties(obj, this);
    }
}
