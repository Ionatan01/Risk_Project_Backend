package org.project.intermodular.risk_project_daw.srv.repository;

import org.project.intermodular.risk_project_daw.model.db.ZonasDb;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ZonasRepository extends JpaRepository<ZonasDb, Long>{

    Page<ZonasDb> findAll (Pageable pageable);

    
}