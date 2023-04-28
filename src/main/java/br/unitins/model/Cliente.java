package br.unitins.model;

import java.util.List;

import javax.persistence.JoinTable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends DefaultEntity {

    private String cpf;
    private String nome;
    @OneToOne
    private Endereco Endereco;
    @OneToOne
    private Telefone telefone;
    @ManyToMany
    @JoinTable(name = "cliente_roupas",
    joinColumns = @JoinColumn(name = "cliente_id"),
    inverseJoinColumns = @JoinColumn(name = "roupas_id"))
    private List<Roupas> listaDeDesejo;




    
    public Endereco getEndereco() {
        return Endereco;
    }
    public void setEndereco(Endereco endereco) {
        Endereco = endereco;
    }
    public Telefone getTelefone() {
        return telefone;
    }
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
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
    public List<Roupas> getListaDeDesejo() {
        return listaDeDesejo;
    }
    public void setListaDeDesejo(List<Roupas> listaDeDesejo) {
        this.listaDeDesejo = listaDeDesejo;
    }
    
    



}
