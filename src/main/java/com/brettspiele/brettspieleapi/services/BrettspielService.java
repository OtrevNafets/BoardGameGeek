package com.brettspiele.brettspieleapi.services;

import com.brettspiele.brettspieleapi.model.Brettspiel;
import com.brettspiele.brettspieleapi.repository.BrettspieleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BrettspielService {
    private final BrettspieleRepository brettspieleRepository;

    public BrettspielService(BrettspieleRepository brettspieleRepository) {
        this.brettspieleRepository = brettspieleRepository;
    }

    public List<Brettspiel> getAll(){
        return brettspieleRepository.findAll();
    }

    public Brettspiel getById(UUID id){
        return brettspieleRepository.findById(id).orElse(null);
    }

    public Brettspiel save(Brettspiel brettspiel){
        return brettspieleRepository.save(brettspiel);
    }

    public void deleteById(UUID id){
        brettspieleRepository.deleteById(id);
    }
}
