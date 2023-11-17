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
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "tb_game")
public class Game implements Serializable{
    private static final long serialVersionUID = 1l;

    @NonNull @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
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
    @NonNull 
    private String shortDescription;
    @NonNull 
    private String longDescription;
}