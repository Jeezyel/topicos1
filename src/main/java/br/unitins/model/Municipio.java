package br.unitins.model;

import javax.persistence.ManyToOne;

public class Municipio extends DefaultEntity{

    private String nome;
    @ManyToOne
    private Estados estados;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }

}
