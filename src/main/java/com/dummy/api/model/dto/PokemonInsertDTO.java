package com.dummy.api.model.dto;

import com.dummy.api.model.enums.PokemonType;

import java.util.List;

public record PokemonInsertDTO(String name, Double weight, Double height, List<PokemonType> types, List<PokemonType> weaknesses, Long isEvolutionOf) {
}
