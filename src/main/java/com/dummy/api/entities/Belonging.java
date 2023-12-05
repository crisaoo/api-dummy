package com.dummy.api.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_belonging")

@NoArgsConstructor
@Getter
@Setter

public class Belonging {
    @EmbeddedId
    private BelongingPK id;
    private Integer position;

    public Belonging(Game game, GameList list, Integer position){
        id = new BelongingPK(game, list);
        this.position = position;
    }
}
