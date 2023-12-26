package com.dummy.api.repository;

import com.dummy.api.entities.Pokeball;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokeballRepository extends JpaRepository<Pokeball, Long> {
}
