package com.dummy.api.entities;

import com.dummy.api.enums.PokemonType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

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
    @Enumerated(EnumType.STRING)
    private PokemonType types;
    @Enumerated(EnumType.STRING)
    private PokemonType weaknesses;
    @OneToOne
    @JoinColumn(name = "evolution")
    private Pokemon evolution;
    private Double weight;
    private Double height;
}
