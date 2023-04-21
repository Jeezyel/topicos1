package br.unitins.model;

public class Municipio extends DefaultEntity{

    private String nome;
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
