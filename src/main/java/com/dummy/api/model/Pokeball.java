package com.dummy.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

import com.dummy.api.model.enums.PokeballType;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_pokeball")

public class Pokeball implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PokeballType type;
    private Double price;
    @Column(columnDefinition = "TEXT")
    private String description;
}
