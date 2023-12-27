package com.dummy.api.model.enums;

import lombok.Getter;

@Getter

public enum PokeballType {
    REGULAR(0),
    GREAT(1),
    ULTRA(2),
    MASTER(3),
    LOVE(4),
    LURE(5),
    NET(6),
    SAFARI(7),
    LEVEL(8),
    LUXURY(9),
    PREMIER(10),
    DIVE(11),
    NEST(12),
    REPEAT(13),
    TIMER(14),
    QUICK(15),
    DUSK(16),
    SPORT(17),
    HEAL(18),
    CHERISH(19),
    PARK(20),
    DREAM(21),
    BEAST(22),
    FAST(23),
    FRIEND(24),
    HEAVY(25),
    MOON(26);

    private final int code;

    PokeballType(int code) {
        this.code = code;
    }

    public static PokeballType valueOf(int code){
        for(PokeballType type : PokeballType.values())
            if(type.getCode() == code)
                return type;
        throw new IllegalArgumentException("Code pokeball type not found.");
    }
}
