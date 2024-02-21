package org.project.intermodular.risk_project_daw.controller;

import java.util.List;
import java.util.Map;

import org.project.intermodular.risk_project_daw.model.db.ZonasDb;
import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.ZonasList;
import org.project.intermodular.risk_project_daw.srv.ZonasService;
import org.project.intermodular.risk_project_daw.srv.repository.ZonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

   

    @PostMapping("/atacar")
    public ResponseEntity<String> atacarZona(@RequestBody AtaqueRequest ataqueRequest) {
        Long idZonaAtacante = ataqueRequest.getIdZonaAtacante();
        Long idZonaDefensora = ataqueRequest.getIdZonaDefensora();

        ZonasDb zonaAtacante = zonasService.getZonaById(idZonaAtacante);
        ZonasDb zonaDefensora = zonasService.getZonaById(idZonaDefensora);

        if (zonaAtacante == null || zonaDefensora == null) {
            return new ResponseEntity<>("Una o ambas zonas no existen", HttpStatus.BAD_REQUEST);
        }

        
        if (zonaAtacante.getTropas() > zonaDefensora.getTropas()) {
            // El ataque tiene éxito
            int tropasRestantesAtacante = zonaAtacante.getTropas() - zonaDefensora.getTropas();
            zonaAtacante.setTropas(tropasRestantesAtacante);
            zonaDefensora.setTropas(1); // El defensor deja una tropa
            zonasService.actualizarZona(zonaAtacante);
            zonasService.actualizarZona(zonaDefensora);
            return new ResponseEntity<>("Ataque exitoso", HttpStatus.OK);
        } else {
            // El ataque falla
            return new ResponseEntity<>("El ataque fracasó", HttpStatus.OK);
        }
    }

    // Clase de solicitud para el cuerpo de la solicitud de ataque
    static class AtaqueRequest {
        private Long idZonaAtacante;
        private Long idZonaDefensora;

        // Getters y setters
        public Long getIdZonaAtacante() {
            return idZonaAtacante;
        }

        public void setIdZonaAtacante(Long idZonaAtacante) {
            this.idZonaAtacante = idZonaAtacante;
        }

        public Long getIdZonaDefensora() {
            return idZonaDefensora;
        }

        public void setIdZonaDefensora(Long idZonaDefensora) {
            this.idZonaDefensora = idZonaDefensora;
        }
    }

    @PostMapping("/{idZona}/asignar-tropas")
    public ResponseEntity<String> asignarTropasAZona(@PathVariable Long idZona, @RequestBody Map<String, Integer> requestBody) {
        try {
            Integer cantidadTropas = requestBody.get("cantidadTropas");
            zonasService.asignarTropasAZona(idZona, cantidadTropas);
            return new ResponseEntity<>("Tropas asignadas correctamente a la zona", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}