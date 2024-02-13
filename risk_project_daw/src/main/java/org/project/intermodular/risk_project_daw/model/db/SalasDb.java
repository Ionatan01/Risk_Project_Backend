package org.project.intermodular.risk_project_daw.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "salas")
public class SalasDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id_sala;
    private Integer jugador1;
    private Integer jugador2;
    private Integer jugador3;
    private Integer jugador4;
}
