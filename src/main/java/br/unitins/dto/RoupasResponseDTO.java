package br.unitins.dto;

import br.unitins.model.Roupa;

public record RoupasResponseDTO(
    
    long id,
    Float valor,
    String cor,
    String marca,
    String modelo

    ) {
    
    public RoupasResponseDTO(Roupa roupa) {

        this(roupa.getId(),
            roupa.getValor(),
            roupa.getCor(),
            roupa.getMarca(),
            roupa.getModelo());
        
    }

 
    

    

    
    
}
