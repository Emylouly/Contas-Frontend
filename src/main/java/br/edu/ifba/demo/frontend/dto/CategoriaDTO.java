package br.edu.ifba.demo.frontend.dto;


import lombok.Data;

@Data
public class CategoriaDTO {
    private Long idcategoria;
    private String categoriadescricao;
    private String tipo;
}