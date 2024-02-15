package org.project.intermodular.risk_project_daw.controller;

import java.util.List;

import org.project.intermodular.risk_project_daw.model.db.ZonasDb;
import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.PartidaList;
import org.project.intermodular.risk_project_daw.model.dto.SalasList;
import org.project.intermodular.risk_project_daw.model.dto.ZonasList;
import org.project.intermodular.risk_project_daw.srv.PartidaService;
import org.project.intermodular.risk_project_daw.srv.SalasService;
import org.project.intermodular.risk_project_daw.srv.ZonasService;
import org.project.intermodular.risk_project_daw.srv.repository.ZonasRepository;
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
@RequestMapping("/api/risk")
public class ZonasRestController {

    private final ZonasService zonasService;

    public ZonasRestController(ZonasService zonasService) {
        this.zonasService = zonasService;
    }

    @GetMapping("/zonas")
    public PaginaDto<ZonasList> getAllZonas(Pageable pageable) {
        return zonasService.findAllPage(pageable);
    }

 @Autowired
    private ZonasRepository zonaRepository;

    @PostMapping("/crearzonas")
    public ResponseEntity<?> createZonas(@RequestBody List<ZonasDb> zonas) {
        try {
            List<ZonasDb> nuevasZonas = zonaRepository.saveAll(zonas);
            return new ResponseEntity<>(nuevasZonas, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear las zonas: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}