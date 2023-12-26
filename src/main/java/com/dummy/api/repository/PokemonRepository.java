package com.dummy.api.repository;

import com.dummy.api.entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
}
