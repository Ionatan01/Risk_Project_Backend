package org.project.intermodular.risk_project_daw.security.repository;



import org.project.intermodular.risk_project_daw.security.entity.RolDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.project.intermodular.risk_project_daw.security.enums.RolNombre;

import java.util.Optional;


public interface RolRepository extends JpaRepository<RolDb, Integer>{
    Optional<RolDb> findByNombre(RolNombre rolNombre);   
}
