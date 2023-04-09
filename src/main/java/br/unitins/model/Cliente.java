package br.unitins.model;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Cliente extends DefaultEntity {
    private Long id;
    private String cpf;
    private String nome;
    @OneToMany
    private Endereco localEnterga;
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
    public Endereco getLocalEnterga() {
        return localEnterga;
    }
    public void setLocalEnterga(Endereco localEnterga) {
        this.localEnterga = localEnterga;
    }
    public Telefone getTelefone() {
        return telefone;
    }
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
    



}
