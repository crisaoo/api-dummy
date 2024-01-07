package com.dummy.api.service;

import com.dummy.api.model.Pokemon;
import com.dummy.api.model.dto.*;
import com.dummy.api.model.dto.projections.IPokemonMinProj;
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
    public List<PokemonMinDTO> findAll(){
        return toListDTO(repository.findAllPokemons());
    }

    @Transactional(readOnly = true)
    public PokemonFullDTO findById(Long id){
        // TODO: create a custom exception and handle it
        Pokemon obj = repository.findById(id).orElseThrow();
        Pokemon evolution = obj.getEvolution();

        PokemonMinDTO evolutionDTO = null;

        if(evolution != null)
            evolutionDTO = new PokemonMinDTO(evolution.getId(), evolution.getName());

        return new PokemonFullDTO(obj.getName(), obj.getWeight(), obj.getHeight(), evolutionDTO, obj.getTypes(), obj.getWeaknesses());
    }

    @Transactional(readOnly = true)
    public List<PokemonMinDTO> findCounterPokemons(Long id){
        return toListDTO(repository.findCounterPokemons(id));
    }

    @Transactional(readOnly = true)
    public List<PokemonMinDTO> findByType(String type){
        type = type.toUpperCase();
        return toListDTO(repository.findByType(type));
    }

    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Pokemon create(PokemonInsertDTO objInsert){
        Pokemon obj = new Pokemon();
        BeanUtils.copyProperties(objInsert, obj);
        obj = repository.save(obj);

        if(objInsert.isEvolutionOf() != null){
            Pokemon pokemon = repository.findById(objInsert.isEvolutionOf()).orElseThrow();
            pokemon.setEvolution(obj);
        }

        return obj;
    }

    private List<PokemonMinDTO> toListDTO(List<IPokemonMinProj> list){
        return list.stream().map(x ->
            new PokemonMinDTO(x.getId(), x.getName())
        ).toList();
    }
}
