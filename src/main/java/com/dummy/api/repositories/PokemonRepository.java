package com.dummy.api.repositories;

import com.dummy.api.models.dto.projections.IPokemonMinProj;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dummy.api.models.Pokemon;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    @Query(nativeQuery = true, value = """
        SELECT tb_pokemon.id, tb_pokemon.name
        FROM tb_pokemon
    """)
    List<IPokemonMinProj> findAllPokemons();

    @Query(nativeQuery = true, value = """
            SELECT DISTINCT tb_pokemon.id, tb_pokemon.name
            FROM tb_pokemon
            INNER JOIN tb_pokemon_type ON tb_pokemon.id = tb_pokemon_type.pokemon_id
            WHERE tb_pokemon_type.type IN (
                SELECT tb_pokemon_weakness.weakness
                FROM tb_pokemon
                INNER JOIN tb_pokemon_weakness ON tb_pokemon.id = tb_pokemon_weakness.pokemon_id
                WHERE tb_pokemon.id = :pokemonId
            ) AND tb_pokemon.id != :pokemonId
    """)
    List<IPokemonMinProj> findCounterPokemons(Long pokemonId);

    @Query(nativeQuery = true, value = """
        SELECT tb_pokemon.id, tb_pokemon.name
        FROM tb_pokemon
        INNER JOIN tb_pokemon_type ON tb_pokemon.id  = tb_pokemon_type.pokemon_id
        WHERE type = :type
    """)
    List<IPokemonMinProj> findByType(String type);
}
