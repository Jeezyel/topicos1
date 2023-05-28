package br.unitins.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Estados extends DefaultEntity {

    private String nome;
    private String sigla;
    @OneToMany
    private List<Municipio> municipio;


    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public List<Municipio> getMunicipio() {
        return municipio;
    }
    public void setMunicipio(List<Municipio> municipio) {
        this.municipio = municipio;
    }



}
