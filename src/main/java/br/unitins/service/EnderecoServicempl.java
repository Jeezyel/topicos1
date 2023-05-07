package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import br.unitins.dto.EnderecoDTO;
import br.unitins.dto.EnderecoResponseDTO;
import br.unitins.model.Endereco;
import br.unitins.model.Estados;
import br.unitins.repository.EnderecoRepository;
import br.unitins.repository.EstadoRepository;
@ApplicationScoped
public class EnderecoServicempl implements EnderecoService{

    @Inject
    EnderecoRepository enderecoRepository;
    @Inject
    EstadoRepository estadoRepository;

    @Inject
    MunicipioServicempl service;
    
    @Inject
    EstadoRepository estadosRepository;
    
   

    @Inject
    Validator validator;

    @Override
    public List<EnderecoResponseDTO> getAll() {
        List<Endereco> listaEnderecos = enderecoRepository.listAll();

        return listaEnderecos.stream().map(EnderecoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public EnderecoResponseDTO findById(Long id) {
        Endereco entity = enderecoRepository.findById(id);

        return new EnderecoResponseDTO(entity);
    }

    @Override
    public EnderecoResponseDTO create(EnderecoDTO enderecoDTO) {
        validar(enderecoDTO);

        Endereco endereco = new Endereco();
        Estados estados = estadosRepository.findById(enderecoDTO.idEstado());

        endereco.setCep(enderecoDTO.cep());
        endereco.setEnderecoCompleto(enderecoDTO.enderecoCompleto());
        endereco.setComplemento(enderecoDTO.complemento());
        endereco.setReferencia(enderecoDTO.referincia());
        endereco.setEstados(estados);

        enderecoRepository.persist(endereco);

        return new EnderecoResponseDTO(endereco);

    }
    @Override
    public EnderecoResponseDTO update(Long id, EnderecoDTO enderecoDTO) {
        validar(enderecoDTO);

        Endereco endereco = enderecoRepository.findById(id);
        Estados estados = estadosRepository.findById(enderecoDTO.idEstado());

        endereco.setCep(enderecoDTO.cep());
        endereco.setEnderecoCompleto(enderecoDTO.enderecoCompleto());
        endereco.setComplemento(enderecoDTO.complemento());
        endereco.setReferencia(enderecoDTO.referincia());
        endereco.setEstados(estados);

        return new EnderecoResponseDTO(endereco);
    }

    @Override
    public void delete(Long id) {
        enderecoRepository.deleteById(id);
    }

    @Override
    public List<EnderecoResponseDTO> findByNome(String Cep) {
        List<Endereco> listaEnderecos = enderecoRepository.findByNumero(Cep);

        return listaEnderecos.stream().map(EnderecoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return enderecoRepository.count();
    }

    private void validar(EnderecoDTO enderecoDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<EnderecoDTO>> violations = validator.validate(enderecoDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }
    
}
