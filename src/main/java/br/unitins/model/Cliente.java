package br.unitins.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Column(nullable = false, length = 80)
    private String nome;
    @Id    //usando o cpf como chave Primaria 
    private Integer id;
    private String cpf;
    
    private LocalDate dataDeNacimento;


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDate getDataDeNacimento() {
        return dataDeNacimento;
    }
    public void setDataDeNacimento(LocalDate dataDeNacimento) {
        this.dataDeNacimento = dataDeNacimento;
    }

    
    

}

