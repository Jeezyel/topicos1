package br.unitins.dto;


import br.unitins.model.Tamanho;

public class RoupasDTO extends ProdutoDTO{
    
    private String tipoDeTercido;
    private Tamanho tamanho;
    private Integer quantidade;



    
    public String getTipoDeTercido() {
        return tipoDeTercido;
    }
    public void setTipoDeTercido(String tipoDeTercido) {
        this.tipoDeTercido = tipoDeTercido;
    }
    public Tamanho getTamanho() {
        return tamanho;
    }
    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }



    
    






}
