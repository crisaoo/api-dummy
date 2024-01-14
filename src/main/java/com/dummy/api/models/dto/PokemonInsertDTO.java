package com.dummy.api.models.dto;

import com.dummy.api.models.enums.PokemonType;

import java.util.List;

public record PokemonInsertDTO(String name, Double weight, Double height, List<String> types, List<String> weaknesses, Long idEvolution) {
}
