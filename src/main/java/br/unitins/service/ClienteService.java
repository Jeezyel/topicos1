package br.unitins.service;

import java.util.List;

import br.unitins.dto.ClienteDTO;
import br.unitins.dto.ClienteResponseDTO;
import br.unitins.dto.ClienteSimplesDTO;
import br.unitins.dto.ClienteSimplesResponseDTO;
import br.unitins.model.Cliente;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ClienteService {

    // recursos basicos
    Boolean alterarSenha(String login ,String senhaAtual , String novaSenha);

    Boolean alterarSenha(long id ,String senhaAtual , String novaSenha);

    List<ClienteResponseDTO> getAll();

    ClienteResponseDTO findById(Long id);

    Cliente findByIdCli(Long id);

    Cliente findByLogin(String login);

    Cliente findByLoginAndSenha(String login , String hash);

    Cliente findByLoginCli(String login);

    ClienteResponseDTO create(ClienteDTO clienteDTO);

    
    ClienteSimplesResponseDTO createSimplis(ClienteSimplesDTO clienteSimplesDTO);

    ClienteResponseDTO update(String login, ClienteDTO clienteDTO);

    
    ClienteResponseDTO updateNomeImagen(Long id, String nomeImagen);

    void delete(Long id);

    void deleteByLogin(String login);

    // recursos extras

    ClienteResponseDTO findByNome(String nome);

    long count();
    
}
