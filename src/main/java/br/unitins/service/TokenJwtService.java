package br.unitins.service;

import br.unitins.model.Cliente;

public interface TokenJwtService {

    public String generateJwt(Cliente cliente);
    
}
