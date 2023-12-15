package com.dummy.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dummy.api.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
