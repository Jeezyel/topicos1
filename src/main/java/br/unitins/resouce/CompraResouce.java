package br.unitins.resouce;

import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import com.oracle.svm.core.annotate.Delete;

import br.unitins.dto.CompraResponseDTO;
import br.unitins.model.Cliente;
import br.unitins.model.Compra;
import br.unitins.repository.UsuarioRepository;
import br.unitins.service.ClienteService;
import br.unitins.service.CompraService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/compras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraResouce {

    private static final Logger LOG = Logger.getLogger(ClienteResouce.class);

    @Inject
    CompraService compraService;

    @Inject
    ClienteService clienteService;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    JsonWebToken tokenJwt;
/* 

    CRIAR O METODO COMPRA 




    @GET
    @Path("/historico-compras")
    @RolesAllowed({"User"})
    public Response getAll() {

        String login = tokenJwt.getSubject();

        

        try {
            Cliente cliente = clienteService.findByLoginCli(login);
            return Response.ok(compraService.getAll(cliente.getId())).build();
        } catch (NullPointerException e) {

            Result result = new Result(e.getMessage(), false);

            return Response.status(Status.NOT_ACCEPTABLE).entity(result).build();
        } catch(Exception e){

            Result result = new Result(e.getMessage(), false);

            return Response.status(Status.NOT_ACCEPTABLE).entity(result).build();
        }
    }*/

    @GET
    @Path("/compras-andamneto")
    @RolesAllowed({"Admin","User"})
    public CompraResponseDTO getCompraEmAndamento() {
        LOG.info(" pegando a compra em andamento do usuario logado");
        String login = tokenJwt.getSubject();

        return compraService.getCompraEmAndamento(login);
        
    }

    @GET
    @Path("/historico-compras")
    @RolesAllowed({"Admin","User"})
    public List<CompraResponseDTO> getAll() {

        LOG.info(" pegando as compras feito pelo usuario logado");

        String login = tokenJwt.getSubject();

        Cliente cliente = clienteService.findByLoginCli(login);

        return compraService.getAll(cliente.getId());
        
    }

    @POST
    @Path("/insert-itemIntoCompra/{id-compra}{id-roupa}")
    @RolesAllowed({"Admin","User"})
    public void insertItemIntoCompra(@PathParam("id-compra")long idCompa, @PathParam("id-roupa")long idroupa){
        LOG.info(" colocando um item na lisata de compra");
        Compra compra = compraService.findById(idCompa);
        String login = tokenJwt.getSubject();
        
        if (compra.getCliente().getLogin() ==  login) {
            compraService.insertItemIntoCompra(idCompa, idroupa);
        }
    }

    @DELETE
    @Path("/remove-itemCompra/{id-compra}{id-roupa}")
    @RolesAllowed({"Admin","User"})
    public void removeItemCompra(@PathParam("id-compra")long idCompa, @PathParam("id-roupa")long idroupa){
        LOG.info(" removendo um item na lisata de compra");
        Compra compra = compraService.findById(idCompa);
        String login = tokenJwt.getSubject();
        
        if (compra.getCliente().getLogin() ==  login) {
            compraService.removeItemCompra(idCompa, idroupa);
        }
        
    }


}
