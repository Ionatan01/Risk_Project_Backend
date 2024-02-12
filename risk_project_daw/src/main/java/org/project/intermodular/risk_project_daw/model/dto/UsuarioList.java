package org.project.intermodular.risk_project_daw.model.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UsuarioList {
    
    private Long id;
    private Long idsala;
    private String nombre;
    private String nickname;
    private String email;
    private String password;
    private Long idpartida;
}
