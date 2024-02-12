package org.project.intermodular.risk_project_daw.srv.impl;

import java.util.List;

import org.project.intermodular.risk_project_daw.model.db.SalasDb;
import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.SalasList;
import org.project.intermodular.risk_project_daw.srv.SalasService;
import org.project.intermodular.risk_project_daw.srv.mapper.SalasMapper;
import org.project.intermodular.risk_project_daw.srv.repository.SalasRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SalasImplService implements SalasService {
    
    private final SalasRepository salasRepository;

    public SalasImplService(SalasRepository salasRepository) {
        this.salasRepository = salasRepository;
    }

   

    public PaginaDto<SalasList> findAllPage(Pageable pageable) {
        Page<SalasDb> paginaSalasDb = salasRepository.findAll(pageable);
        List<SalasList> partidaLists = SalasMapper.INSTANCE.salasDbListToSalasList(paginaSalasDb.getContent());
        return new PaginaDto<>(
            paginaSalasDb.getNumber(),
            paginaSalasDb.getSize(),
            paginaSalasDb.getTotalElements(),
            paginaSalasDb.getTotalPages(),
            partidaLists,
            paginaSalasDb.getSort());
    }



    



  




}
