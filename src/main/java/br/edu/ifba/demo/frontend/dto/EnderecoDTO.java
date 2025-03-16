package br.edu.ifba.demo.frontend.dto;

import lombok.Data;

@Data
public class EnderecoDTO {
    private Long idendereco;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String cep;
}