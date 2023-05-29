package br.unitins.resouce;

//import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;

//import com.oracle.svm.core.annotate.Inject;

//import br.unitins.dto.ClienteResponseDTO;
//import br.unitins.repository.ClienteRepository;
//import br.unitins.service.ClienteService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
//import jakarta.ws.rs.core.Response;
//import net.bytebuddy.asm.Advice.Return;
import jakarta.ws.rs.Produces;

@Path("/usuariologado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UsuarioLogadoResouce {

    @Inject
    UsuarioService usuarioService;
    
    @GET
    @RolesAllowed({"Admin"})
    public List<UsuarioResponseDTO> getAll() {

        return usuarioService.getAll();
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
