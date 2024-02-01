package org.project.intermodular.risk_project_daw.security.service;



import java.util.Optional;

import org.project.intermodular.risk_project_daw.security.entity.RolDb;
import org.project.intermodular.risk_project_daw.security.entity.enums.RolNombre;
import org.project.intermodular.risk_project_daw.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.constraints.NotNull;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public Optional<RolDb> getByRolNombre(RolNombre rolNombre) {
        return rolRepository.findByNombre(rolNombre);
    }

    public void save(@NotNull RolDb rol) {
        rolRepository.save(rol);
    }
}
