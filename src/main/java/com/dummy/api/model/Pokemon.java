package com.dummy.api.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.dummy.api.model.enums.PokemonType;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @JoinColumn(name = "evolution_id")
    @OneToOne
    private Pokemon evolution;
    private Double weight;
    private Double height;

    // TODO: add a list size validation, the max value should be 2 and the min be 1
    @ElementCollection(targetClass =  PokemonType.class)
    @JoinTable(name = "tb_pokemon_type", joinColumns = @JoinColumn(name = "pokemon_id"))
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @Fetch(FetchMode.JOIN)
    private List<PokemonType> types;

    @ElementCollection(targetClass =  PokemonType.class)
    @JoinTable(name = "tb_pokemon_weakness", joinColumns = @JoinColumn(name = "pokemon_id"))
    @Column(name = "weakness")
    @Enumerated(EnumType.STRING)
    @Fetch(FetchMode.JOIN)
    private List<PokemonType> weaknesses;
}
