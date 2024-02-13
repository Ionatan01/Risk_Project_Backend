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
    private Long jugador1;
    private Long jugador2;
    private Long jugador3;
    private Long jugador4;
}
