package com.dummy.api.model.records;

import com.dummy.api.model.enums.PokemonType;

import java.util.List;

public record PokemonInsert(String name, Double weight, Double height, List<PokemonType> types, List<PokemonType> weaknesses) {
}
