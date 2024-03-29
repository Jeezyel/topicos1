package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;


import br.unitins.dto.TelefoneDTO;
import br.unitins.dto.TelefoneResponseDTO;
import br.unitins.model.Cliente;
import br.unitins.model.Telefone;
import br.unitins.repository.TelefoneRepository;
@ApplicationScoped
public class TelefoneServicempl implements TelefoneService{

    
    private static final Logger LOG = Logger.getLogger(TelefoneServicempl.class);

    @Inject
    TelefoneRepository telefoneRepository;

    @Inject
    Validator validator;

    @Inject
    ClienteService clienteService;

    @Inject
    JsonWebToken tokenJwt;

    @Override
    public List<TelefoneResponseDTO> getAll() {
        return telefoneRepository.findAll().stream().map(TelefoneResponseDTO::new).collect(Collectors.toList());  
    }

    @Override
    public TelefoneResponseDTO getTelefone() {

        LOG.info("pegando o login do usuario logado");
        String login = tokenJwt.getSubject();

        LOG.info("pegando o usuario");
        Cliente cliente = clienteService.findByLogin(login);

        if(cliente.getTelefone() != null){
            return new TelefoneResponseDTO(cliente.getTelefone());
        }

        return null;
    }

    @Override
    public TelefoneResponseDTO findById(Long id) {
        Telefone telefone = telefoneRepository.findById(id);

        return new TelefoneResponseDTO(telefone);
    }

    @Override
    public TelefoneResponseDTO create(TelefoneDTO telefoneDTO) {
        
        validar(telefoneDTO);
        
        Telefone telefone = new Telefone();

        telefone.setCodigoDeArea(telefoneDTO.codigoDeArea());
        telefone.setNumero(telefoneDTO.numero());
        telefone.setCelular(telefoneDTO.celular());

        telefoneRepository.isPersistent(telefone);

        return new TelefoneResponseDTO(telefone);
    }

    @Override
    public TelefoneResponseDTO update(Long id, TelefoneDTO telefoneDTO) {
        validar(telefoneDTO);

        Telefone telefone = telefoneRepository.findById(id);

        telefone.setCodigoDeArea(telefoneDTO.codigoDeArea());
        telefone.setNumero(telefoneDTO.numero());
        telefone.setCelular(telefoneDTO.celular());

        return new TelefoneResponseDTO(telefone);
    }

    @Override
    public void delete(Long id) {
        telefoneRepository.deleteById(id);
    }

    @Override
    public List<TelefoneResponseDTO> findByNome(String numero) {
        List<Telefone> listaTelefones = telefoneRepository.findByNumero(numero);

        return listaTelefones.stream().map(TelefoneResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return telefoneRepository.count();
    }

    private void validar(TelefoneDTO telefoneDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<TelefoneDTO>> violations = validator.validate(telefoneDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }

    
    
}
