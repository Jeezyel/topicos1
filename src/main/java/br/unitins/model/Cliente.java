package br.unitins.model;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Cliente extends DefaultEntity {
    private Long id;
    private String cpf;
    private String nome;
    @OneToMany
    private List<Endereco> Endereco;
    @OneToOne
    private Telefone telefone;




    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Telefone getTelefone() {
        return telefone;
    }
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
    public List<Endereco> getEndereco() {
        return Endereco;
    }
    public void setEndereco(List<Endereco> endereco) {
        Endereco = endereco;
    }
    



}
