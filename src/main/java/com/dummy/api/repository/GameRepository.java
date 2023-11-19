package com.dummy.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dummy.api.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
    
}
