package br.unitins.resouce;

//import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.aplication.Result;
import br.unitins.dto.UsuarioDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.model.Usuario;
import br.unitins.service.UsuarioServicempl;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;

//import com.oracle.svm.core.annotate.Inject;

//import br.unitins.dto.ClienteResponseDTO;
//import br.unitins.repository.ClienteRepository;
//import br.unitins.service.ClienteService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response.Status;
//import jakarta.ws.rs.core.Response;
//import net.bytebuddy.asm.Advice.Return;
import jakarta.ws.rs.Produces;

@Path("/usuariologado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UsuarioLogadoResouce {

    @Inject
    UsuarioServicempl usuarioService;

    @Inject
    JsonWebToken tokenJwt;

    @GET
    @Path("/dados-pessoais")
    @RolesAllowed({ "User" })
    public Response getDadosPessoais() {

        String login = tokenJwt.getSubject();

        Usuario usuario = usuarioService.getByLoginUsuario(login);

        UsuarioResponseDTO dadosPessoaisUsuario = new UsuarioResponseDTO(usuario);

        return Response.ok(dadosPessoaisUsuario).build();
    }
    
    @GET
    @Path("/getall")
    @RolesAllowed({"Admin"})
    public List<UsuarioResponseDTO> getAll() {

        return usuarioService.getAll();
    }

    @POST
    @Path("/insert")
    @RolesAllowed({"Admin","User"})
    public Response insert(UsuarioDTO usuarioDto) {

        try {

            return Response
                    .status(Status.CREATED) // 201
                    .entity(usuarioService.insert(usuarioDto))
                    .build();
        } catch (ConstraintViolationException e) {

            Result result = new Result(e.getConstraintViolations());

            return Response
                    .status(Status.NOT_FOUND)
                    .entity(result)
                    .build();
        }
    }

    @DELETE
    @Path("/delete{login}")
    @RolesAllowed({"Admin","User"})
    public Response delete(@PathParam("login") String login) throws IllegalArgumentException, NotFoundException {


        usuarioService.delete(login);

        return Response
                .status(Status.NO_CONTENT)
                .build();
    }

    @PUT
    @Path("/update{login}")
    @RolesAllowed({"Admin"})
    public Boolean updateusuario(@PathParam("login") String login){




        return false;
    }

    @GET
    @Path("/getbylogin{login}")
    @RolesAllowed({"Admin"})
    public UsuarioResponseDTO getByLogin(@PathParam("login") String login) throws NotFoundException {

        return usuarioService.getByLogin(login);
    }

   /*  @Inject
    JsonWebToken token;

    @Inject
    ClienteService service;

    
    public Response getCliente(){
        String logado = token.getSubject();
        ClienteResponseDTO cliente = service.findByLogado(logado);

        return Response.ok().build();
    }*/
}
