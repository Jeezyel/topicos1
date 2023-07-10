package br.unitins.dto;


import br.unitins.model.Cliente;
import br.unitins.model.Endereco;
import br.unitins.model.Telefone;

public record FinalizarCadastroResponseDTO(
    
    Endereco enderecos,
    Telefone telefone
) {
    public FinalizarCadastroResponseDTO (Cliente DTO){
        this(DTO.getEndereco(), DTO.getTelefone());
    }
    
}
