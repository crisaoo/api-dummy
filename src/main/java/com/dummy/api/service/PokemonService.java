package com.dummy.api.service;

import com.dummy.api.model.Pokemon;
import com.dummy.api.model.records.PokemonDTO;
import com.dummy.api.model.records.PokemonEvolutionDTO;
import com.dummy.api.model.records.PokemonListDTO;
import com.dummy.api.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PokemonService {
    private final PokemonRepository repository;

    @Transactional(readOnly = true)
    public List<PokemonListDTO> findAll(){
        List<Pokemon> obj = repository.findAll();
        List<PokemonListDTO> dto = new ArrayList<>();

        for (Pokemon pokemon: obj)
            dto.add(new PokemonListDTO(pokemon.getId(), pokemon.getName(), pokemon.getWeight(), pokemon.getHeight()));
        return dto;
    }

    @Transactional(readOnly = true)
    public PokemonDTO findById(Long id){
        // TODO: create a custom exception and handle it
        Pokemon obj = repository.findById(id).orElseThrow();
        Pokemon evolution = obj.getEvolution();

        PokemonEvolutionDTO evolutionDTO = null;

        if(evolution != null)
            evolutionDTO = new PokemonEvolutionDTO(evolution.getId(), evolution.getName());

        return new PokemonDTO(obj.getId(), obj.getName(), obj.getWeight(), obj.getHeight(), evolutionDTO, obj.getTypes(), obj.getWeaknesses());
    }

    @Transactional(readOnly = true)
    public List<PokemonListDTO> findCounterPokemons(Long id){
        List<Pokemon> obj = repository.findCounterPokemons(id);
        List<PokemonListDTO> dto = new ArrayList<>();

        for (Pokemon pokemon : obj)
            dto.add(new PokemonListDTO(pokemon.getId(), pokemon.getName(), pokemon.getWeight(), pokemon.getHeight()));

        return dto;
    }
}
