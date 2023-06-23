package br.unitins.resouce;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import br.unitins.dto.AuthUsuarioDTO;
import br.unitins.model.Cliente;
import br.unitins.service.ClienteService;
import br.unitins.service.HashService;
import br.unitins.service.HashServicempl;
import br.unitins.service.TokenJwtService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResourceX {


    private static final Logger LOG = Logger.getLogger(ClienteResouce.class);

    @Inject
    HashService hashService;

    @Inject
    ClienteService clienteService;

    @Inject
    TokenJwtService tokenService;

    @Inject
    JsonWebToken jwt;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response login (AuthUsuarioDTO authDTO) {


        LOG.info(" pegando o cliente ");
        Cliente cliente = clienteService.findByLoginAndSenha(authDTO.login(), authDTO.senha());

        if (cliente == null) {
            LOG.info(" caso não encontra o cliente");
            return Response.status(Status.NO_CONTENT)
                .entity("Usuario não encontrado").build();
        } 
        LOG.info(" caso não de nada de errado");
        return Response.ok()
            .header("Authorization", tokenService.generateJwt(cliente)).build();
         
        
           
        
    }

    //so pra poder pegar o hash pra colocar no inportSQL
    public static void main(String[] args) {
        
        HashServicempl hashService = new HashServicempl();

		
		System.out.print("e so isso: " + hashService.getHashSenha("123"));
	}

   

}
