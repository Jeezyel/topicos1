package br.unitins.dto;

import java.util.Set;

import br.unitins.model.Cliente;
import br.unitins.model.Perfil;

public record UsuarioDTO( 

long id,
String login,
String senha,
String nomeImagem,
Set<Perfil> perfis,
Cliente cliente) {
    
}
