package br.unitins.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.dto.CompraResponseDTO;
import br.unitins.dto.ItemCompraDTO;
import br.unitins.model.Cliente;
import br.unitins.model.Compra;
import br.unitins.repository.CompraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CompraServicempl implements CompraService{

    @Inject
    CompraRepository compraRepository;

    @Inject
    ClienteService clienteService;



    @Override
    public List<CompraResponseDTO> getAll(Long idUsuario) {
    

        Cliente cliente = clienteService.findByLoginCli(clienteService.findById(idUsuario).login());

        List<Compra> listaCompra = compraRepository.findByClientelist(cliente);


        return listaCompra.stream().map(CompraResponseDTO::new).collect(Collectors.toList());
    }

   // dsfa

    @Override
    public CompraResponseDTO getCompraEmAndamento(String loginn) {
        
        Cliente cliente = clienteService.findByLoginCli(loginn);

        return new CompraResponseDTO(compraRepository.findByCliente(cliente));


    }

    // creio que esse DTO de itemCompra n vai ser recomendado acho que seria melhor o id do produto 
    // pq ia vc ia no pegar a compra a os item compra lista de produto localizar o produto ai remover 
    // ai pra adicionar e so quando chegar na lista add e salvar na quela compra tupo update de compra 

    @Override
    public void insertItemIntoCompra(Long idCompra, ItemCompraDTO itemCompraDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertItemIntoCompra'");
    }

    @Override
    public void removeItemCompra(Long idUsuario, Long idItemCompra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItemCompra'");
    }
    // acho que esse metodo faz e chamar o metodo pagamento pra finalizar 
    @Override
    public void finishCompra(Long idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finishCompra'");
    }
    
}
