package com.dummy.api.models.pk;

import java.io.Serial;
import java.io.Serializable;

import com.dummy.api.models.enums.PokeballType;
import com.dummy.api.models.enums.PokemonType;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable

public class CatchRatePK implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Column(name="pokemon_type_code")
    private PokemonType pokemonType;
    @Column(name="pokeball_type_code")
    private PokeballType pokeballType;
}
