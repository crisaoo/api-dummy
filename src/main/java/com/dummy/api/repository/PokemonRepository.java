package com.dummy.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dummy.api.model.Pokemon;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    @Query(nativeQuery = true, value = """
        SELECT DISTINCT tb_pokemon.*
        FROM tb_pokemon
        INNER JOIN tb_pokemon_type ON tb_pokemon.id = tb_pokemon_type.pokemon_id
        WHERE tb_pokemon_type.type IN (
            SELECT tb_pokemon_weakness.weakness
            FROM tb_pokemon
            INNER JOIN tb_pokemon_weakness ON tb_pokemon.id = tb_pokemon_weakness.pokemon_id
            WHERE tb_pokemon.id = :pokemonId
        ) AND tb_pokemon.id != :pokemonId
    """)
    List<Pokemon> findCounterPokemons(Long pokemonId);

    @Query(nativeQuery = true, value = """
        SELECT *
        FROM tb_pokemon
        INNER JOIN tb_pokemon_type ON tb_pokemon.id  = tb_pokemon_type.pokemon_id
        WHERE type = :type
    """)
    List<Pokemon> findByType(String type);
}
