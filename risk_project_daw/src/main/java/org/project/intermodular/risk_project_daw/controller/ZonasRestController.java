package org.project.intermodular.risk_project_daw.controller;

import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.PartidaList;
import org.project.intermodular.risk_project_daw.model.dto.SalasList;
import org.project.intermodular.risk_project_daw.model.dto.ZonasList;
import org.project.intermodular.risk_project_daw.srv.PartidaService;
import org.project.intermodular.risk_project_daw.srv.SalasService;
import org.project.intermodular.risk_project_daw.srv.ZonasService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/risk/")
public class ZonasRestController {

    private final ZonasService zonasService;

    public ZonasRestController(ZonasService zonasService) {
        this.zonasService = zonasService;
    }

    @GetMapping("/zonas")
    public PaginaDto<ZonasList> getAllZonas(Pageable pageable) {
        return zonasService.findAllPage(pageable);
    }



    
}