package com.dummy.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dummy.api.model.Pokeball;

public interface PokeballRepository extends JpaRepository<Pokeball, Long> {
}
