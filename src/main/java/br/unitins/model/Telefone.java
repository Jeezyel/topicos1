package br.unitins.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Telefone extends DefaultEntity{

    @Column
    private String codigoDeArea;
    @Column
    private String numero;
    @Column
    private Boolean celular;

    
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
