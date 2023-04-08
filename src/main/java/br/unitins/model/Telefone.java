package br.unitins.model;

public class Telefone {
    private long id;
    private String codigoDeArea;
    private String numero;
    private Boolean celular;

    
    public Telefone(Telefone telefone) {
        this.codigoDeArea = telefone.codigoDeArea;
        this.numero = telefone.numero;
        this.celular = telefone.celular;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCodigoDeArea() {
        return codigoDeArea;
    }
    public void setCodigoDeArea(String codigoDeArea) {
        this.codigoDeArea = codigoDeArea;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Boolean getCelular() {
        return celular;
    }
    public void setCelular(Boolean celular) {
        this.celular = celular;
    } 


    
}
