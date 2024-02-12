package org.project.intermodular.risk_project_daw.srv;

import org.project.intermodular.risk_project_daw.model.dto.PaginaDto;
import org.project.intermodular.risk_project_daw.model.dto.SalasList;
import org.springframework.data.domain.Pageable;

public interface SalasService {

    PaginaDto<SalasList> findAllPage(Pageable pageable);
}
