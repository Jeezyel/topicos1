package br.unitins.dto;

import br.unitins.model.Roupas;

public record RoupasResponseDTO(
    
    Float valor,
    String cor,
    String marca,
    String modelo

    ) {
    
    public RoupasResponseDTO(Roupas roupas) {

        this(roupas.getValor(),roupas.getCor(),roupas.getMarca(),roupas.getModelo());
        
    }

 
    

    

    
    
}
