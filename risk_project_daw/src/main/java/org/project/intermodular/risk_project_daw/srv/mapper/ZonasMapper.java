package org.project.intermodular.risk_project_daw.srv.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.project.intermodular.risk_project_daw.model.db.ZonasDb;
import org.project.intermodular.risk_project_daw.model.dto.ZonasList;

@Mapper
public interface ZonasMapper {
    ZonasMapper INSTANCE = Mappers.getMapper(ZonasMapper.class);

    ZonasList zonasDbToZonasList(ZonasDb zonasDb);

    List<ZonasList> zonasDbListToZonasList(List<ZonasDb> salasDb);

    List<ZonasDb> zonasDbToZonasList(List<ZonasDb> content);
}