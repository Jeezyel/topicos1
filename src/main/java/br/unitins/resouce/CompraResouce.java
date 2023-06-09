package br.unitins.resouce;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.aplication.Result;
import br.unitins.model.Cliente;
import br.unitins.service.ClienteService;
import br.unitins.service.CompraService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/compras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraResouce {

    @Inject
    CompraService compraService;

    @Inject
    ClienteService clienteService;

    @Inject
    JsonWebToken tokenJwt;

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

            return Response.status(Status.NOT_FOUND).entity(result).build();
        } catch(Exception e){

            Result result = new Result(e.getMessage(), false);

            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }
}
