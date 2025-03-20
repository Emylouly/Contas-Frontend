package br.edu.ifba.demo.frontend.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ParcelaDTO {
    
    private long idparcela;
    private LocalDate parceladatavencimento;
    private int numeroparcela;
    private double valorparcela;
    private ContasDTO idcontas;
}
