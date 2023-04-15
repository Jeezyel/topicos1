package br.unitins.dto;

import java.util.List;

public record ClienteDTO(

    String cpf,
    String nome,
    List<EnderecoDTO> localEnterga,
    TelefoneDTO telefone   
) {
    
}
