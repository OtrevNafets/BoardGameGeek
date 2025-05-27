package com.brettspiele.brettspieleapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Brettspiel {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String genre;
    private int amountOfPlayers;
    private int playTime;

    @Column(nullable = false)
    private float price;
}
