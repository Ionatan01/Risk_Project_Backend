package org.project.intermodular.risk_project_daw.controller;

import java.util.Optional;

import org.project.intermodular.risk_project_daw.model.db.PartidaDb;
import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.PartidaList;
import org.project.intermodular.risk_project_daw.srv.PartidaService;
import org.project.intermodular.risk_project_daw.srv.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/risk/")
public class PartidaRestController {

    private final PartidaService partidaService;

    public PartidaRestController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping("/partidas")
    public PaginaDto<PartidaList> getAllPartidas(Pageable pageable) {
        return partidaService.findAllPage(pageable);
    }

 @GetMapping("/partidas/{id}")
    public ResponseEntity<PartidaDb> getPartidaById(@PathVariable("id") Long id) {
        Optional<PartidaDb> partida = partidaService.getPartidaById(id);
        return partida.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

     @Autowired
    private PartidaRepository partidaRepository;

    @PostMapping("/crearpartida")
    public ResponseEntity<?> createPartida(@RequestBody PartidaDb partida) {
        try {
            PartidaDb nuevaPartida = partidaRepository.save(partida);
            return new ResponseEntity<>(nuevaPartida, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la partida: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}