package com.dummy.api.model.dto;

import com.dummy.api.model.enums.PokemonType;

import java.util.List;

public record PokemonFullDTO(String name, Double weight, Double height, PokemonMinDTO evolution, List<PokemonType> types, List<PokemonType> weaknesses) {
}
