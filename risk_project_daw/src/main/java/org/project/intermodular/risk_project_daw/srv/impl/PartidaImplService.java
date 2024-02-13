package org.project.intermodular.risk_project_daw.srv.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.project.intermodular.risk_project_daw.model.db.PartidaDb;
import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.PartidaList;
import org.project.intermodular.risk_project_daw.srv.PartidaService;
import org.project.intermodular.risk_project_daw.srv.mapper.PartidaMapper;
import org.project.intermodular.risk_project_daw.srv.repository.PartidaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PartidaImplService implements PartidaService {

    private final PartidaRepository partidaRepository;

    public PartidaImplService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    public PaginaDto<PartidaList> findAllPage(Pageable pageable) {
        Page<PartidaDb> paginaPartidaDb = partidaRepository.findAll(pageable);
        List<PartidaList> partidaLists = PartidaMapper.INSTANCE
                .partidaDbListToPartidaList(paginaPartidaDb.getContent());
        return new PaginaDto<>(
                paginaPartidaDb.getNumber(),
                paginaPartidaDb.getSize(),
                paginaPartidaDb.getTotalElements(),
                paginaPartidaDb.getTotalPages(),
                partidaLists,
                paginaPartidaDb.getSort());
    }

    @Override
    public Optional<PartidaDb> getPartidaById(Long id) {
        return partidaRepository.findById(id);
    }

    @Override
    public PartidaDb createPartida(PartidaDb partida) {
        return partidaRepository.save(partida);
    }

}
