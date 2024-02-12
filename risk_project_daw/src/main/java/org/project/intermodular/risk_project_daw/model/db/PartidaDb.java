package org.project.intermodular.risk_project_daw.model.db;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "partidas")
public class PartidaDb {
    @Id
    private Long id_partida;
    private String estado_partida;
    private int num_jugadores;
}
