package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import jakarta.ws.rs.core.Response.Status;

import jakarta.validation.Validator;
import jakarta.ws.rs.core.Response;
import br.unitins.aplication.Result;
import br.unitins.dto.PagamentoDTO;
import br.unitins.dto.PagamentoResponseDTO;
import br.unitins.model.Pagamento;
import br.unitins.repository.PagamentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;




@ApplicationScoped
public class pagamentoServicempl implements pagamentoService {

    private static final Logger LOG = Logger.getLogger(pagamentoServicempl.class);

    @Inject
    PagamentoRepository pagamentoRepository;
    
    @Inject
    Validator validator;

    @Override
    public PagamentoResponseDTO create(PagamentoDTO pagamento) {
        validar(pagamento);

        Pagamento pagamentoo = new Pagamento();

        pagamentoo.setCompra(pagamento.compra());
        pagamentoo.setQuantidadeParcela(pagamento.quantidadeParcela());
        pagamentoo.setValorParcela(pagamento.valorParcela());
        pagamentoo.setTipoPagamento(pagamento.tipoPagamento());
        pagamentoo.setConfirmarPagamento(pagamento.confirmarPagamento());

        pagamentoRepository.persist(pagamentoo);

        return new PagamentoResponseDTO(pagamentoo);
    }

    @Override
    public PagamentoResponseDTO finalizarCompra(long id) {
        
        Pagamento pagamentoo = pagamentoRepository.findById(id);;
        
        pagamentoo.setConfirmarPagamento(true);

        pagamentoRepository.persist(pagamentoo);
        
        return new PagamentoResponseDTO(pagamentoo);
    }

    @Override
    public PagamentoResponseDTO findById(Long id) {
        return new PagamentoResponseDTO(pagamentoRepository.findById(id)); 
    }

    @Override
    public List<PagamentoResponseDTO> getAll() {

        List<Pagamento> listaPagamentos = pagamentoRepository.listAll();

        return listaPagamentos.stream().map(PagamentoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return pagamentoRepository.count();
    }

    private void validar(PagamentoDTO clienteDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<PagamentoDTO>> violations = validator.validate(clienteDTO);

        LOG.debug("verificando se ja foi criado ");
        if (!violations.isEmpty()){

            LOG.debug("retornando uma Exception ");
            throw new ConstraintViolationException(violations);
        }


    }

   
    
}
