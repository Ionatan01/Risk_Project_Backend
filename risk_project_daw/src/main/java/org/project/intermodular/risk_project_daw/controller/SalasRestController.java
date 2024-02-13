package org.project.intermodular.risk_project_daw.controller;

import org.project.intermodular.risk_project_daw.model.db.SalasDb;
import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.PartidaList;
import org.project.intermodular.risk_project_daw.model.dto.SalasList;
import org.project.intermodular.risk_project_daw.srv.PartidaService;
import org.project.intermodular.risk_project_daw.srv.SalasService;
import org.project.intermodular.risk_project_daw.srv.repository.SalasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/risk/")
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

}