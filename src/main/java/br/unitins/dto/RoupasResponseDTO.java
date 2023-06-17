package br.unitins.dto;

import br.unitins.model.Roupas;

public record RoupasResponseDTO(
    
    long id,
    Float valor,
    String cor,
    String marca,
    String modelo

    ) {
    
    public RoupasResponseDTO(Roupas roupas) {

        this(roupas.getId(),
            roupas.getValor(),
            roupas.getCor(),
            roupas.getMarca(),
            roupas.getModelo());
        
    }

 
    

    

    
    
}
