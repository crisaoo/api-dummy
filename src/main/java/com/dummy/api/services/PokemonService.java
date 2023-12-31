package com.dummy.api.services;

import com.dummy.api.exceptions.PokemonNotFoundException;
import com.dummy.api.models.Pokemon;
import com.dummy.api.models.dto.*;
import com.dummy.api.models.dto.projections.IPokemonMinProj;
import com.dummy.api.repositories.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PokemonService {
    private final PokemonRepository repository;

    // TODO: handle the follow exceptions:
    //  - type non-existent
    //  - pokemon already exists
    //  - pokemon evolution doesn't exists
    //  - pokemon evolution cannot be deleted
    //  - pokemon evolution cannot be itself

    @Transactional(readOnly = true)
    public List<PokemonMinDTO> findAll(){
        return toListDTO(repository.findAllPokemons());
    }

    @Transactional(readOnly = true)
    public PokemonFullDTO findById(Long id){
        Pokemon obj = repository.findById(id).orElseThrow(() -> new PokemonNotFoundException(id));
        Pokemon evolution = obj.getEvolution();

        PokemonMinDTO evolutionDTO = null;
        if(evolution != null)
            evolutionDTO = new PokemonMinDTO(evolution.getId(), evolution.getName());

        return new PokemonFullDTO(obj.getName(), obj.getWeight(), obj.getHeight(), evolutionDTO, obj.getTypes(), obj.getWeaknesses());
    }

    @Transactional(readOnly = true)
    public List<PokemonMinDTO> findCounterPokemons(Long id){
        List<IPokemonMinProj> obj = repository.findCounterPokemons(id);

        if (obj.isEmpty())
            throw new PokemonNotFoundException("Pokemon with ID " + id + " not found.");

        return toListDTO(obj);
    }

    @Transactional(readOnly = true)
    public List<PokemonMinDTO> findByType(String type){
        return toListDTO(repository.findByType(type.toUpperCase()));
    }

    @Transactional
    public void deleteById(Long id){
        Pokemon obj = repository.findById(id).orElseThrow(() -> new PokemonNotFoundException(id));
        repository.delete(obj);
    }

    @Transactional
    public Pokemon create(PokemonInsertDTO objInsert){
        Pokemon obj = new Pokemon();
        BeanUtils.copyProperties(objInsert, obj);
        obj = repository.save(obj);

        Long idEvolution = objInsert.idEvolution();
        if(idEvolution != null){
            Pokemon pokemon = repository.findById(idEvolution).orElseThrow(
                    () -> new PokemonNotFoundException("Pokemon evolution with ID " + String.valueOf(idEvolution) + " not found.")
            );
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
