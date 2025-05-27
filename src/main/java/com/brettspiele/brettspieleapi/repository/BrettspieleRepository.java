package com.brettspiele.brettspieleapi.repository;

import com.brettspiele.brettspieleapi.model.Brettspiel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrettspieleRepository extends JpaRepository<Brettspiel, UUID> {
}
