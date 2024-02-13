package org.project.intermodular.risk_project_daw.srv;

import java.util.Optional;

import org.project.intermodular.risk_project_daw.model.db.PartidaDb;
import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.PartidaList;
import org.springframework.data.domain.Pageable;

public interface PartidaService {

    PaginaDto<PartidaList> findAllPage(Pageable pageable);

    public Optional<PartidaDb> getPartidaById(Long id);

    public PartidaDb createPartida(PartidaDb partida);

}
