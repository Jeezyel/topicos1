package br.unitins.dto;

import java.util.List;

import br.unitins.model.Tamanho;

public class RoupasDTO extends ProdutoDTO{
    
    private String tipoDeTercido;
    private List<ClienteDTO> ListaDeDesejo;
    private Tamanho tamanho;



    
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
    public List<ClienteDTO> getListaDeDesejo() {
        return ListaDeDesejo;
    }
    public void setListaDeDesejo(List<ClienteDTO> listaDeDesejo) {
        ListaDeDesejo = listaDeDesejo;
    }



    
    






}
