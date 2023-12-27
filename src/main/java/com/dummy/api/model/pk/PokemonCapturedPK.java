package com.dummy.api.model.pk;

import java.io.Serial;
import java.io.Serializable;

import com.dummy.api.model.Pokeball;
import com.dummy.api.model.Pokemon;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable

public class PokemonCapturedPK implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    @OneToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;
    @OneToOne
    @JoinColumn(name = "pokeball_id")
    private Pokeball pokeball;
}
