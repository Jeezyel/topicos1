package br.unitins.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cliente {
    private String nome;
    private String cpf;
    @Id
    private LocalDate dataDeNacimento;
    

}
