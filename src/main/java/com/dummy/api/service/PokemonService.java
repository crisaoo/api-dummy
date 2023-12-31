package com.dummy.api.service;

import com.dummy.api.model.Pokemon;
import com.dummy.api.model.records.PokemonDTO;
import com.dummy.api.model.records.PokemonEvolutionDTO;
import com.dummy.api.model.records.PokemonListDTO;
import com.dummy.api.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PokemonService {
    private final PokemonRepository repository;

    @Transactional(readOnly = true)
    public List<PokemonListDTO> findAll(){
        return toDtoList(repository.findAll());
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
        return toDtoList(repository.findCounterPokemons(id));
    }

    @Transactional(readOnly = true)
    public List<PokemonListDTO> findByType(String type){
        type = type.toUpperCase();
        return toDtoList(repository.findByType(type));
    }

    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public void create(PokemonDTO dto){
        Pokemon obj = new Pokemon();
        BeanUtils.copyProperties(dto, obj);
        repository.save(obj);
    }

    private List<PokemonListDTO> toDtoList(List<Pokemon> list){
        List<PokemonListDTO> dto = new ArrayList<>();

        for (Pokemon pokemon : list)
            dto.add(new PokemonListDTO(pokemon.getId(), pokemon.getName(), pokemon.getWeight(), pokemon.getHeight()));

        return dto;
    }
}
