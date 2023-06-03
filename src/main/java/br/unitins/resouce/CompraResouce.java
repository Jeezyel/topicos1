package br.unitins.resouce;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.aplication.Result;
import br.unitins.model.Usuario;
import br.unitins.service.CompraService;
import br.unitins.service.CompraServicempl;
import br.unitins.service.UsuarioService;
import br.unitins.service.UsuarioServicempl;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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
    UsuarioService usuarioService;

    @Inject
    JsonWebToken tokenJwt;

    @GET
    @Path("/historico-compras")
    @RolesAllowed({"User"})
    public Response getAll() {

        String login = tokenJwt.getSubject();

        

        try {
            Usuario usuario = usuarioService.getByLoginUsuario(login);
            return Response.ok(compraService.getAll(usuario.getId())).build();
        } catch (NullPointerException e) {

            Result result = new Result(e.getMessage(), false);

            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }
}
