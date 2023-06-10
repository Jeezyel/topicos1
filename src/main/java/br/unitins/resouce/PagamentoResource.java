package br.unitins.resouce;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

import org.jboss.logging.Logger;


import br.unitins.service.pagamentoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import br.unitins.dto.PagamentoResponseDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PagamentoResource {
    
    private static final Logger LOG = Logger.getLogger(ClienteResouce.class);


    @Inject
    pagamentoService pagamentoService;



    @GET
    @Path("/getAll")
    @RolesAllowed({"Admin"})
    public List<PagamentoResponseDTO> getAll(){
        LOG.info("buscnado todos os pagamentos");
        return pagamentoService.getAll();
    }

    @POST
    @Path("/finalizarCompra/{id}")
    @RolesAllowed({"Admin"})
    public void finalizarCompra(@PathParam("id") long id){
        LOG.info(" finalizando o pagamento");
        pagamentoService.finalizarCompra(id);
    }

    @GET
    @Path("/findbyid/{id}")
    @RolesAllowed({"Admin"})
    public PagamentoResponseDTO findById(@PathParam("id") long id ){
        LOG.info(" procurando o pagamento por id");
        return pagamentoService.findById(null);
    }

    @GET
    @Path("/count")
    @RolesAllowed({"Admin"})
    public long count(){
        LOG.info("count");
        return pagamentoService.count();
    }
}
