package org.project.intermodular.risk_project_daw.srv;

import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.ZonasList;
import org.springframework.data.domain.Pageable;

public interface ZonasService {

    PaginaDto<ZonasList> findAllPage(Pageable pageable);
}
