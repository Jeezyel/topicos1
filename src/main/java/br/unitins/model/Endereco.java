package br.unitins.model;

import javax.persistence.OneToMany;

public class Endereco extends DefaultEntity{


    private String cep;
    private String enderecoCompleto;
    private String complemento;
    private String referencia; 
    @OneToMany
    private Estados estados;

    
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public Estados getEstados() {
        return estados;
    }
    public void setEstados(Estados estados) {
        this.estados = estados;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }
    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getReferincia() {
        return referencia;
    }
    public void setReferincia(String referincia) {
        this.referencia = referincia;
    }
    

    
}
