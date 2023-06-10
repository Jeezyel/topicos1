package br.unitins.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.dto.CompraResponseDTO;
import br.unitins.model.Cliente;
import br.unitins.model.Compra;
import br.unitins.model.Roupas;
import br.unitins.repository.CompraRepository;
import br.unitins.repository.RoupasRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CompraServicempl implements CompraService{

    

    @Inject
    CompraRepository compraRepository;

    @Inject
    ClienteService clienteService;

    @Inject
    RoupasRepository roupasRepository;


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
    public void insertItemIntoCompra(Long idCompra, long idRoupa) {
        Compra compra = compraRepository.findById(idCompra);

        Roupas roupas = roupasRepository.findByID(idCompra);


        compra.getItemCompra().getRoupas().add(roupas);

        compraRepository.persist(compra);
    }

    @Override
    public void removeItemCompra(Long idCompra, long idRoupa) {
        
        Compra compra = compraRepository.findById(idCompra);

        Roupas roupas = roupasRepository.findByID(idCompra);

        for (int i = 0; i <= compra.getItemCompra().getRoupas().size(); i++) {

            if (compra.getItemCompra().getRoupas().get(i) == roupas) {

                compra.getItemCompra().getRoupas().remove(i);

            }
            
        }

        compraRepository.persist(compra);
    }

    @Override
    public Compra findById(Long idUsuario) {

        return compraRepository.findByID(idUsuario);
    }
    
    
}
