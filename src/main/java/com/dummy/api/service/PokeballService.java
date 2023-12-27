package com.dummy.api.service;

import com.dummy.api.model.Pokeball;
import com.dummy.api.repository.PokeballRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service

public class PokeballService {
    private final PokeballRepository repository;

    @Transactional(readOnly = true)
    public List<Pokeball> findAll(){
        List<Pokeball> list = repository.findAll();
        return list;
    }
}