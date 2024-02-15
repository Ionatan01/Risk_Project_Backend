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
@Table(name= "zonas")
public class ZonasDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_zona;
    private Long jugador_duenyo;
    private String descripcion;
    private Integer tropas;
   
}
