package com.dummy.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.dummy.api.model.enums.PokemonType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})

@Entity
@Table(name = "tb_pokemon")

public class Pokemon implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long evolution;
    private Double weight;
    private Double height;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = PokemonType.class)
    @CollectionTable(name = "tb_pokemon_type")
    @Column(name = "type")
    private List<PokemonType> types;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = PokemonType.class)
    @CollectionTable(name = "tb_pokemon_weakness")
    @Column(name = "weakness")
    private List<PokemonType> weaknesses;
}
