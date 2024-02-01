package org.project.intermodular.risk_project_daw.security.repository;


import java.util.Optional;

import org.project.intermodular.risk_project_daw.security.entity.UsuarioDb;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<UsuarioDb, Integer>{
    Optional<UsuarioDb> findByNickname(String nickname);
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
    
}
