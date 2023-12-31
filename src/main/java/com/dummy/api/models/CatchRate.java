package com.dummy.api.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

import com.dummy.api.models.pk.CatchRatePK;

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
    private CatchRatePK pk;
    private Double catchRate;
}
