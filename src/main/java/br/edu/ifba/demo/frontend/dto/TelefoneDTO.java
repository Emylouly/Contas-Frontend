package br.edu.ifba.demo.frontend.dto;

import lombok.Data;

@Data
public class TelefoneDTO {
    private long idtelefone;
    private String numero;
    private String tiponumero;
    private UsuarioDTO idUsuario;
}
