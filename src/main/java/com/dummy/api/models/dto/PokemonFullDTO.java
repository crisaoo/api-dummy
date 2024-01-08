package com.dummy.api.models.dto;

import com.dummy.api.models.enums.PokemonType;

import java.util.List;

public record PokemonFullDTO(String name, Double weight, Double height, PokemonMinDTO evolution, List<PokemonType> types, List<PokemonType> weaknesses) {
}
