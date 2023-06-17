package br.unitins.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Endereco extends DefaultEntity{

    @Column( nullable = false ) 
    private String cep;
    @Column( nullable = false ) 
    private String enderecoCompleto;
    @Column( nullable = false ) 
    private String complemento;
    private String referencia; 
    @ManyToOne
    @JoinColumn(name = "estados" )
    private Estados estados;

    

    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
    public Estados getEstados() {
        return estados;
    }
    public void setEstados(Estados estados) {
        this.estados = estados;
    }
    

    
}
