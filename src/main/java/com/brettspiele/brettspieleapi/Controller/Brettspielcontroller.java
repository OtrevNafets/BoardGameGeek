package com.brettspiele.brettspieleapi.Controller;

import com.brettspiele.brettspieleapi.DTO.BrettspielDto;
import com.brettspiele.brettspieleapi.Mapper.BrettspielMapper;
import com.brettspiele.brettspieleapi.model.Brettspiel;
import com.brettspiele.brettspieleapi.services.BrettspielService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/brettspiele")
public class Brettspielcontroller {
    private final BrettspielService brettspielService;

    public Brettspielcontroller(BrettspielService brettspielService) {
        this.brettspielService = brettspielService;
    }

    @Operation(summary = "Liefert alle Brettspiele")
    @GetMapping
    public List<BrettspielDto> brettspiele() {
        List<Brettspiel> allBoardgames = brettspielService.getAll();
        return allBoardgames.stream().map(BrettspielMapper::toBrettspielDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brettspiel> brettspiel(@PathVariable UUID id) {
        Optional<Brettspiel> brettspielOpt = Optional.ofNullable(brettspielService.getById(id));
                return brettspielOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Brettspiel createBrettspiel(@RequestBody Brettspiel brettspiel) {
        return brettspielService.save(brettspiel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brettspiel> updateBrettspiel(@PathVariable UUID id, @RequestBody Brettspiel updateBrettspiel) {
        Optional<Brettspiel> brettspielOpt = Optional.ofNullable(brettspielService.getById(id));

        if (brettspielOpt.isPresent()) {
            updateBrettspiel.setId(id);
            Brettspiel updated = brettspielService.save(updateBrettspiel);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> spielLöschen(@PathVariable UUID id) {
        Optional<Brettspiel> brettspielOpt = Optional.ofNullable(brettspielService.getById(id));

        if (brettspielOpt.isPresent()) {
            brettspielService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
