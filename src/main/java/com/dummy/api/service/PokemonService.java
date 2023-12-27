package com.dummy.api.service;

import com.dummy.api.model.Pokemon;
import com.dummy.api.model.records.PokemonRecord;
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
    public List<PokemonRecord> findAll(){
        List<Pokemon> list = repository.findAll();
        List<PokemonRecord> listDTO = new ArrayList<>();

        for (Pokemon pokemon: list)
            listDTO.add(new PokemonRecord(pokemon.getName(), pokemon.getWeight(), pokemon.getHeight()));
        return listDTO;
    }
}
