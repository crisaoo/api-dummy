package com.dummy.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dummy.api.models.Pokeball;

public interface PokeballRepository extends JpaRepository<Pokeball, Long> {
}
