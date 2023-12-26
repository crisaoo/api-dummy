package com.dummy.api.enums;

import lombok.Getter;

@Getter
public enum PokeballType {
    REGULAR(1),
    GREAT(2),
    ULTRA(3),
    MASTER(4),
    LOVE(5),
    LURE(6),
    NET(7),
    SAFARI(8),
    LEVEL(9),
    LUXURY(10),
    PREMIER(11),
    DIVE(12),
    NEST(13),
    REPEAT(14),
    TIMER(15),
    QUICK(16),
    DUSK(17),
    SPORT(18),
    HEAL(19),
    CHERISH(20),
    PARK(21),
    DREAM(22),
    BEAST(23),
    FAST(24),
    FRIEND(25),
    HEAVY(26),
    MOON(27);

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
