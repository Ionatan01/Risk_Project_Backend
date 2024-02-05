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
@Table(name= "partidas")
public class PartidasDb {
    @Id
    private Integer partidaid;

    private Date fecha;

    private String estado;
}
