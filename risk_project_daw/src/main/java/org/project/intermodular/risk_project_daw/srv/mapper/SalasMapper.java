package org.project.intermodular.risk_project_daw.srv.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.project.intermodular.risk_project_daw.model.db.SalasDb;
import org.project.intermodular.risk_project_daw.model.dto.SalasList;

@Mapper
public interface SalasMapper {
    SalasMapper INSTANCE = Mappers.getMapper(SalasMapper.class);

    SalasList salasDbToSalasList(SalasDb salasDb);

    List<SalasList> salasDbListToSalasList(List<SalasDb> salasDb);

    List<SalasDb> salasDbToSalasList(List<SalasDb> content);
}