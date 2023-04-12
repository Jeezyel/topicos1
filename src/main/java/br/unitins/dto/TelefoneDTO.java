package br.unitins.dto;

public class TelefoneDTO {
    
    private String codigoDeArea;
    private String numero;
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
