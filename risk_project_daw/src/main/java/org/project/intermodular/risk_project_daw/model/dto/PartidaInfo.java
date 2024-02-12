package org.project.intermodular.risk_project_daw.model.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PartidaInfo {
    private Integer id_partida;
    private String estado_partida;
    private int num_jugadores;
}
