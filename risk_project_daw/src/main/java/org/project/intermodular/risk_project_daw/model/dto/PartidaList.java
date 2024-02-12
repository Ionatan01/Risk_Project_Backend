package org.project.intermodular.risk_project_daw.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PartidaList {
    
    private Integer id_partida;
    private String estado_partida;
    private int num_jugadores;
}
