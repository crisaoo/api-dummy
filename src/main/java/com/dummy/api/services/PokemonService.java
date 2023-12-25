package com.dummy.api.services;

import com.dummy.api.dto.PokemonDTO;
import com.dummy.api.entities.Pokemon;
import com.dummy.api.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonService {
    private final PokemonRepository repository;

    @Transactional(readOnly = true)
    public List<PokemonDTO> findAll(){
        List<Pokemon> list = repository.findAll();
        List<PokemonDTO> listDTO = list.stream().map(PokemonDTO::new).toList();
        return listDTO;
    }
}
