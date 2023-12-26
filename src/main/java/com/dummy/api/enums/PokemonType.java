package com.dummy.api.enums;

import lombok.Getter;

@Getter
public enum PokemonType {
    NORMAL(1),
    FIRE(2),
    WATER(3),
    ELECTRIC(4),
    GRASS(5),
    ICE(6),
    FIGHTING(7),
    POISON(8),
    GROUND(9),
    FLYING(10),
    PSYCHIC(11),
    BUG(12),
    ROCK(13),
    GHOST(14),
    DRAGON(15),
    DARK(16),
    STEEL(17),
    FAIRY(18);

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
