package org.project.intermodular.risk_project_daw.security.service;

import java.util.Optional;

import org.project.intermodular.risk_project_daw.security.entity.UsuarioDb;
import org.project.intermodular.risk_project_daw.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotNull;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<UsuarioDb> getByNickname(String nickname){
        return usuarioRepository.findByNickname(nickname);
    }

    public boolean existsByNickname(String nickname){
        return usuarioRepository.existsByNickname(nickname);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(@NotNull UsuarioDb usuario){
        usuarioRepository.save(usuario);
    }
}
