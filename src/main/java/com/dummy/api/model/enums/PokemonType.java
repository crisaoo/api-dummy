package com.dummy.api.model.enums;

import lombok.Getter;

@Getter

public enum PokemonType {
    NORMAL(0),
    FIRE(1),
    WATER(2),
    ELECTRIC(3),
    GRASS(4),
    ICE(5),
    FIGHTING(6),
    POISON(7),
    GROUND(8),
    FLYING(9),
    PSYCHIC(10),
    BUG(11),
    ROCK(12),
    GHOST(13),
    DRAGON(14),
    DARK(15),
    STEEL(16),
    FAIRY(17);

    private final int code;

    private PokemonType(int code){
        this.code = code;
    }

        public static PokemonType valueOf(int code){
            for(PokemonType type : PokemonType.values())
                if(type.getCode() == code)
                    return type;

            throw new IllegalArgumentException("Code pokemon type not found.");
        }
}
