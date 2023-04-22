package br.unitins.model;

import javax.persistence.OneToMany;

public class Estados extends DefaultEntity {

    private String nome;
    private String sigla;
    @OneToMany
    private Municipio municipio;


    public Municipio getMunicipio() {
        return municipio;
    }
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
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



}
