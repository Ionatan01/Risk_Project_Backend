package org.project.intermodular.risk_project_daw.srv.impl;

import java.util.List;
import java.util.Optional;

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



    @Override
    public ZonasDb getZonaById(Long idZona) {
        Optional<ZonasDb> zonaOptional = zonasRepository.findById(idZona);
        return zonaOptional.orElse(null);
    }



    @Override
    public void actualizarZona(ZonasDb zona) {
        zonasRepository.save(zona);
    }

    public void asignarTropasAZona(Long idZona, Integer cantidadTropas) {
        Optional<ZonasDb> zonaOptional = zonasRepository.findById(idZona);
        if (zonaOptional.isPresent()) {
            ZonasDb zona = zonaOptional.get();
            zona.setTropas(cantidadTropas);
            zonasRepository.save(zona);
        } else {
            throw new IllegalArgumentException("No se encontró ninguna zona con el ID especificado");
        }
    }


    



  




}
