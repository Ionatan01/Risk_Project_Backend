package org.project.intermodular.risk_project_daw.srv.impl;

import java.util.List;

import org.project.intermodular.risk_project_daw.model.db.ZonasDb;
import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.ZonasList;
import org.project.intermodular.risk_project_daw.srv.ZonasService;
import org.project.intermodular.risk_project_daw.srv.mapper.ZonasMapper;
import org.project.intermodular.risk_project_daw.srv.repository.ZonasRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ZonasImplService implements ZonasService {
    
    private final ZonasRepository zonasRepository;

    public ZonasImplService(ZonasRepository zonasRepository) {
        this.zonasRepository = zonasRepository;
    }

   

    public PaginaDto<ZonasList> findAllPage(Pageable pageable) {
        Page<ZonasDb> paginaZonasDb = zonasRepository.findAll(pageable);
        List<ZonasList> partidaLists = ZonasMapper.INSTANCE.zonasDbListToZonasList(paginaZonasDb.getContent());
        return new PaginaDto<>(
            paginaZonasDb.getNumber(),
            paginaZonasDb.getSize(),
            paginaZonasDb.getTotalElements(),
            paginaZonasDb.getTotalPages(),
            partidaLists,
            paginaZonasDb.getSort());
    }



    



  




}
