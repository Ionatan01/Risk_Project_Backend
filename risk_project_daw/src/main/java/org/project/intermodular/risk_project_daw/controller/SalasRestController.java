package org.project.intermodular.risk_project_daw.controller;

import java.util.Optional;

import org.project.intermodular.risk_project_daw.model.db.SalasDb;
import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.SalasList;
import org.project.intermodular.risk_project_daw.srv.SalasService;
import org.project.intermodular.risk_project_daw.srv.repository.SalasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/risk")
public class SalasRestController {

    private final SalasService salasService;

    public SalasRestController(SalasService salasService) {
        this.salasService = salasService;
    }

    @GetMapping("/salas")
    public PaginaDto<SalasList> getAllSalas(Pageable pageable) {
        return salasService.findAllPage(pageable);
    }

    @Autowired
    private SalasRepository salaRepository;

    @PostMapping("/crearsala")
    public ResponseEntity<?> createSala(@RequestBody SalasDb sala) {
        try {
            SalasDb nuevaSala = salaRepository.save(sala);
            return new ResponseEntity<>(nuevaSala, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la sala: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addplayer")
    public ResponseEntity<?> addPlayerToSala(@RequestParam Long salaId, @RequestParam Long playerId) {
        Optional<SalasDb> optionalSala = salaRepository.findById(salaId);
        if (optionalSala.isPresent()) {
            SalasDb sala = optionalSala.get();
            if (sala.getJugador1() == 0) {
                sala.setJugador1(playerId);
            } else if (sala.getJugador2() == 0) {
                sala.setJugador2(playerId);
            } else if (sala.getJugador3() == 0) {
                sala.setJugador3(playerId);
            } else if (sala.getJugador4() == 0) {
                sala.setJugador4(playerId);
            } else {
                return new ResponseEntity<>("La sala está llena.", HttpStatus.BAD_REQUEST);
            }
            salaRepository.save(sala);
            return new ResponseEntity<>("Jugador añadido a la sala correctamente.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sala no encontrada.", HttpStatus.NOT_FOUND);
        }
    }

}