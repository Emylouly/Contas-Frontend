package br.edu.ifba.demo.frontend.dto;
import lombok.Data;

@Data
public class UsuarioDTO {
    private long idusuario;
    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;
    private EnderecoDTO idendereco;

}



