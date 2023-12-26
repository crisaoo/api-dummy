package com.dummy.api.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "pk")
@Entity
@Table(name = "tb_catch_rate")
public class CatchRate implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private CatchRatePK pk = new CatchRatePK();
    private Double catchRate;
}
