package br.unitins.service;

import java.util.List;

import br.unitins.dto.ClienteDTO;
import br.unitins.dto.ClienteResponseDTO;
import br.unitins.model.Cliente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;

@ApplicationScoped
public interface ClienteService {

    // recursos basicos
    Boolean alterarSenha(Long id ,String senhaAtual , String novaSenha);

    List<ClienteResponseDTO> getAll();

    ClienteResponseDTO findById(Long id);

    ClienteResponseDTO findByLogin(String login);

    Cliente findByLoginCli(String login);

    ClienteResponseDTO create(ClienteDTO clienteDTO);

    ClienteResponseDTO update(Long id, ClienteDTO clienteDTO);

    void delete(Long id);

    // recursos extras

    List<ClienteResponseDTO> findByNome(String nome);

    long count();
    
}
