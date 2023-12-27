package com.dummy.api.service;

import com.dummy.api.model.Pokemon;
import com.dummy.api.model.dto.PokemonDTO;
import com.dummy.api.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service

public class PokemonService {
    private final PokemonRepository repository;

    @Transactional(readOnly = true)
    public List<PokemonDTO> findAll(){
        List<Pokemon> list = repository.findAll();
        List<PokemonDTO> listDTO = list.stream().map(PokemonDTO::new).toList();
        return listDTO;
    }
}
