package com.dummy.api.models;

import java.time.LocalDate;

import com.dummy.api.models.pk.PokemonCapturedPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"pk"})

@Entity
@Table(name = "tb_pokemon_captured")

public class PokemonCaptured {
    // TODO: date
    private LocalDate captureDate;
    private String location;
    private String trainer;
    @EmbeddedId
    private PokemonCapturedPK pk;
}
