package com.dummy.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tb_game")
public class Game implements Serializable{
    private static final long serialVersionUID = 1l;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private final Long id;
    @NonNull 
    private String title;
    @NonNull @Column(name = "game_year")
    private Integer year;
    @NonNull 
    private String genre;
    @NonNull 
    private String platforms;
    @NonNull 
    private Double score;
    @NonNull 
    private String imgUrl;
    @NonNull @Column(columnDefinition = "TEXT")
    private String shortDescription;
    @NonNull @Column(columnDefinition = "TEXT")
    private String longDescription;
}