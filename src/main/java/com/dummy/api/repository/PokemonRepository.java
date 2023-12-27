package com.dummy.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dummy.api.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
}
