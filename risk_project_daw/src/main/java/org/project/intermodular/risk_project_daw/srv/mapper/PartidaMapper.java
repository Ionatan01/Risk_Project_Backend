package org.project.intermodular.risk_project_daw.srv.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.project.intermodular.risk_project_daw.model.db.PartidaDb;
import org.project.intermodular.risk_project_daw.model.dto.PartidaList;

@Mapper
public interface PartidaMapper {
    PartidaMapper INSTANCE = Mappers.getMapper(PartidaMapper.class);

    PartidaList partidaDbToPartidaList(PartidaDb partidaDb);
   
    List<PartidaList> partidaDbListToPartidaList(List<PartidaDb> partidaDb);

    List<PartidaDb> partidaDbToEquiposList(List<PartidaDb> content);
}