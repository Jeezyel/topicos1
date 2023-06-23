package br.unitins.model;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente extends DefaultEntity {
    @Column( nullable = false )
    private String cpf;
    @Column( nullable = false)
    private String nome;
    @OneToOne
    private Endereco Endereco;
    @OneToOne
    private Telefone telefone;
    
    @Column( nullable = false )
    private String login;
    @Column( nullable = false )
    private String senha;
    private String nomeImagem;
    @ElementCollection
    @CollectionTable(name = "perfis", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"))
    @Column(name = "perfil", length = 8, nullable = false)
    private Set<Perfil> perfis;
   /* @ManyToMany
    @JoinTable(name = "cliente_roupas",
    joinColumns = @JoinColumn(name = "cliente_id"),
    inverseJoinColumns = @JoinColumn(name = "roupa_id"))
    private List<Roupa> listaDeDesejo; */




    
    
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
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNomeImagem() {
        return nomeImagem;
    }
    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }
    public Set<Perfil> getPerfis() {
        return perfis;
    }
    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
    
    
    



}
