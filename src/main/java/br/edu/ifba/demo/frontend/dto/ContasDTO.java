package br.edu.ifba.demo.frontend.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ContasDTO implements Serializable {
    private long idcontas;
    private String descricao;
    private float valor;
    private LocalDate  datavencimento;
    private LocalDate datapagamento;
    private String tipoconta;
    private boolean statuscontas;
    private UsuarioDTO idusuario;
    private CategoriaDTO idcategoria;
}