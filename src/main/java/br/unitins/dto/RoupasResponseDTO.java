package br.unitins.dto;

import java.util.List;

import br.unitins.model.Cliente;
import br.unitins.model.Roupas;

public record RoupasResponseDTO(

    Integer quantidade,
    Float valor,
    String cor,
    String marca,
    String modelo,
    List<Cliente> cliente

    ) {
    
    public RoupasResponseDTO(Roupas roupas) {

        this(roupas.getQuantidade(),roupas.getValor(),roupas.getCor(),roupas.getMarca(),roupas.getModelo(),roupas.getListaDeDesejo());
        
    }

 
    

    

    
    
}
