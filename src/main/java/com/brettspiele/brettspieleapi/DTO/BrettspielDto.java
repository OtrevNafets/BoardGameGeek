package com.brettspiele.brettspieleapi.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class BrettspielDto {
    @NotNull
    private UUID id;
    private String name;
    private String genre;
    private float price;
    private int amountOfPlayers;
    private int playTime;
}
