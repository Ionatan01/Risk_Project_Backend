package org.project.intermodular.risk_project_daw.srv.repository;

import org.project.intermodular.risk_project_daw.model.db.PartidaDb;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PartidaRepository extends JpaRepository<PartidaDb, Long>{

    Page<PartidaDb> findAll (Pageable pageable);

    
}