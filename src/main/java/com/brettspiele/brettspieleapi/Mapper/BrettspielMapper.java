package com.brettspiele.brettspieleapi.Mapper;

import com.brettspiele.brettspieleapi.DTO.BrettspielDto;
import com.brettspiele.brettspieleapi.model.Brettspiel;

public class BrettspielMapper {
    public static BrettspielDto toBrettspielDto(Brettspiel b) {
        BrettspielDto dto = new BrettspielDto();
        dto.setId(b.getId());
        dto.setName(b.getName());
        dto.setGenre(b.getGenre());
        dto.setPrice(b.getPrice());
        dto.setPlayTime(b.getPlayTime());
        dto.setAmountOfPlayers(b.getAmountOfPlayers());
        return dto;
    }
}
