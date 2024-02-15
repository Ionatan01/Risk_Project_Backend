package org.project.intermodular.risk_project_daw.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ZonasInfo {
   
    private Long id_zona;
    private Long jugador_duenyo;
    private String descripcion;
    private Integer tropas;
}
