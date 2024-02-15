package org.project.intermodular.risk_project_daw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.project.intermodular.risk_project_daw.model.db.PartidaDb;
import org.project.intermodular.risk_project_daw.model.db.SalasDb;
import org.project.intermodular.risk_project_daw.model.db.ZonasDb;
import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.PartidaList;
import org.project.intermodular.risk_project_daw.srv.PartidaService;
import org.project.intermodular.risk_project_daw.srv.repository.PartidaRepository;
import org.project.intermodular.risk_project_daw.srv.repository.SalasRepository;
import org.project.intermodular.risk_project_daw.srv.repository.ZonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/risk")
public class PartidaRestController {

    private final PartidaService partidaService;

    public PartidaRestController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private SalasRepository salaRepository;

    @Autowired
    private ZonasRepository zonasRepository;

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

     

    
   /*@PostMapping("/crearpartida")
public ResponseEntity<?> createPartida() {
    try {
        // Obtener todas las salas llenas
        List<SalasDb> salasLlenas = salaRepository.findByJugador4IsNotNull();

        if (!salasLlenas.isEmpty()) {
            // Crear una nueva partida
            PartidaDb nuevaPartida = new PartidaDb();
            nuevaPartida.setEstado_partida("activa");

            // Obtener los IDs de los jugadores en las salas llenas y agregarlos al campo num_jugadores
            List<Long> jugadores = new ArrayList<>();
            for (SalasDb sala : salasLlenas) {
                if (sala.getJugador1() != 0) jugadores.add(sala.getJugador1());
                if (sala.getJugador2() != 0) jugadores.add(sala.getJugador2());
                if (sala.getJugador3() != 0) jugadores.add(sala.getJugador3());
                if (sala.getJugador4() != 0) jugadores.add(sala.getJugador4());
            }
            nuevaPartida.setNum_jugadores(jugadores.size());

            // Guardar la nueva partida en la base de datos
            PartidaDb partidaGuardada = partidaRepository.save(nuevaPartida);

            // Eliminar las salas llenas ya que se ha creado la partida
            salaRepository.deleteAll(salasLlenas);

            return new ResponseEntity<>(partidaGuardada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("No hay salas llenas para crear una partida.", HttpStatus.BAD_REQUEST);
        }
    } catch (Exception e) {
        return new ResponseEntity<>("Error al crear la partida: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}*/

@PostMapping("/crearpartida")
public ResponseEntity<?> createPartida() {
    try {
        // Obtener todas las salas llenas
        List<SalasDb> salasLlenas = salaRepository.findByJugador4IsNotNull();

        if (!salasLlenas.isEmpty()) {
            // Crear una nueva partida
            PartidaDb nuevaPartida = new PartidaDb();
            nuevaPartida.setEstado_partida("activa");

            // Obtener los IDs de los jugadores en las salas llenas y agregarlos al campo num_jugadores
            List<Long> jugadores = new ArrayList<>();
            for (SalasDb sala : salasLlenas) {
                if (sala.getJugador1() != 0) jugadores.add(sala.getJugador1());
                if (sala.getJugador2() != 0) jugadores.add(sala.getJugador2());
                if (sala.getJugador3() != 0) jugadores.add(sala.getJugador3());
                if (sala.getJugador4() != 0) jugadores.add(sala.getJugador4());
            }
            nuevaPartida.setNum_jugadores(jugadores.size());

            // Guardar la nueva partida en la base de datos
            PartidaDb partidaGuardada = partidaRepository.save(nuevaPartida);

            // Asignar una zona a cada jugador con 25 tropas
            for (Long jugadorId : jugadores) {
                ZonasDb nuevaZona = new ZonasDb();
                nuevaZona.setJugador_duenyo(jugadorId);
                nuevaZona.setTropas(25);
                // Asignar otras propiedades según sea necesario
                zonasRepository.save(nuevaZona);
            }

            // Eliminar las salas llenas ya que se ha creado la partida
            salaRepository.deleteAll(salasLlenas);

            return new ResponseEntity<>(partidaGuardada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("No hay salas llenas para crear una partida.", HttpStatus.BAD_REQUEST);
        }
    } catch (Exception e) {
        return new ResponseEntity<>("Error al crear la partida: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



}