package br.unitins.dto;

import java.util.List;

import br.unitins.model.Endereco;
import br.unitins.model.Telefone;

public record ClienteDTO(

    String cpf,
    String nome,
    List<Endereco> localEnterga,
    Telefone telefone   
) {
    
}
