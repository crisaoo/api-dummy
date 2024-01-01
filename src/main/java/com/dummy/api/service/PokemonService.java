package com.dummy.api.service;

import com.dummy.api.model.Pokemon;
import com.dummy.api.model.records.PokemonDTO;
import com.dummy.api.model.records.PokemonEvolution;
import com.dummy.api.model.records.PokemonInsert;
import com.dummy.api.model.records.PokemonList;
import com.dummy.api.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PokemonService {
    private final PokemonRepository repository;

    @Transactional(readOnly = true)
    public List<PokemonList> findAll(){
        return toListDTO(repository.findAll());
    }

    @Transactional(readOnly = true)
    public PokemonDTO findById(Long id){
        // TODO: create a custom exception and handle it
        Pokemon obj = repository.findById(id).orElseThrow();
        Pokemon evolution = obj.getEvolution();

        PokemonEvolution evolutionDTO = null;

        if(evolution != null)
            evolutionDTO = new PokemonEvolution(evolution.getId(), evolution.getName());

        return new PokemonDTO(obj.getName(), obj.getWeight(), obj.getHeight(), evolutionDTO, obj.getTypes(), obj.getWeaknesses());
    }

    @Transactional(readOnly = true)
    public List<PokemonList> findCounterPokemons(Long id){
        return toListDTO(repository.findCounterPokemons(id));
    }

    @Transactional(readOnly = true)
    public List<PokemonList> findByType(String type){
        type = type.toUpperCase();
        return toListDTO(repository.findByType(type));
    }

    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Pokemon create(PokemonInsert newObj){
        Pokemon obj = new Pokemon();
        BeanUtils.copyProperties(newObj, obj);
        return repository.save(obj);
    }

    private List<PokemonList> toListDTO(List<Pokemon> list){
        return list.stream().map(pokemon ->
            new PokemonList(pokemon.getId(), pokemon.getName(), pokemon.getWeight(), pokemon.getHeight())
        ).toList();
    }
}
