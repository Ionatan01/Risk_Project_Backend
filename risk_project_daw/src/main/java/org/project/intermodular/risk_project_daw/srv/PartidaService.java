package org.project.intermodular.risk_project_daw.srv;

import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.PartidaList;
import org.springframework.data.domain.Pageable;

public interface PartidaService {

    PaginaDto<PartidaList> findAllPage(Pageable pageable);
}
