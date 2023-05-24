package br.unitins.dto;

import java.util.List;

import br.unitins.model.Endereco;
import br.unitins.model.Roupas;
import br.unitins.model.Telefone;

public record ClienteDTO(
    long id,
    String cpf,
    String nome,
    Endereco enderecos,
    Telefone telefone,
    List<Roupas> listaDeDesejo,
    String nomeImagem,
    String login,
    String senha
) {

    public ClienteDTO(int i, String string, String string2, EnderecoDTO endereco, TelefoneDTO telefone2, String string3,
            String string4, String string5, String string6) {
    }
    
}
