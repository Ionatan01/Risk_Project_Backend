package org.project.intermodular.risk_project_daw.model.db;

import java.sql.Date;

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
@Table(name= "jugadores")
public class JugadoresDb {
    @Id
    private Integer jugadoresid;
    private String estado;
}
