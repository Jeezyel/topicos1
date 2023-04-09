package br.unitins.model;

public class Endereco extends DefaultEntity{


    private Long id;
    private String cep;
    private String enderecoCompleto;
    private String complemento;
    private String referencia; 

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
