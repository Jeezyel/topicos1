package br.unitins.resouce;

//import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.aplication.Result;
import br.unitins.dto.ClienteDTO;
import br.unitins.dto.ClienteResponseDTO;
import br.unitins.form.ImageForm;
import br.unitins.model.Cliente;
import br.unitins.service.ClienteService;
import br.unitins.service.FileService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;

//import com.oracle.svm.core.annotate.Inject;

//import br.unitins.repository.ClienteRepository;
//import br.unitins.service.ClienteService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;
//import jakarta.ws.rs.core.Response;
//import net.bytebuddy.asm.Advice.Return;
import jakarta.ws.rs.Produces;

@Path("/usuariologado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UsuarioLogadoResouce {

    @Inject
    ClienteService ClienteService;

    @Inject
    JsonWebToken tokenJwt;

    @Inject
    FileService fileService;
/* 
    @GET
    @Path("/dados-pessoais")
    @RolesAllowed({ "User" })
    public Response getDadosPessoais() {

        String login = tokenJwt.getSubject();

        Usuario usuario = usuarioService.getByLoginUsuario(login);

        UsuarioResponseDTO dadosPessoaisUsuario = new UsuarioResponseDTO(usuario);

        return Response.ok(dadosPessoaisUsuario).build();
    }*/

    @GET
    @RolesAllowed({"Admin","User"})
    public ClienteResponseDTO getUsuario() {

        // obtendo o login a partir do token
        String login = tokenJwt.getSubject();
        ClienteResponseDTO usuario = ClienteService.findByLogin(login);

        return usuario;
    }

    @PATCH
    @Path("/novaimagem")
    @RolesAllowed({"Admin","User"})
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ImageForm form){
        String nomeImagem = "";

        try {
            nomeImagem = fileService.salvarImagemUsuario(form.getImagem(), form.getNomeImagem());
        } catch (IOException e) {
            Result result = new Result(e.getMessage());
            return Response.status(Status.CONFLICT).entity(result).build();
        }

        // obtendo o login a partir do token
        String login = tokenJwt.getSubject();
        Cliente cliente =  ClienteService.findByLoginCli(login);

        cliente = ClienteService.updateNomeImagen(cliente.getId(), nomeImagem);

        return Response.ok(cliente).build();

    }

    @GET
    @Path("/download/{nomeImagem}")
    @RolesAllowed({"Admin","User"})
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment;filename="+nomeImagem);
        return response.build();
    }
    
    @GET
    @Path("/getall")
    @RolesAllowed({"Admin"})
    public List<ClienteResponseDTO> getAll() {

        return ClienteService.getAll();
    }

    @POST
    @Path("/insert")
    @RolesAllowed({"Admin","User"})
    public Response insert(ClienteDTO clienteDTO) {

        try {

            return Response
                    .status(Status.CREATED) // 201
                    .entity(ClienteService.create(clienteDTO))
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


        ClienteService.deleteByLogin(login);

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
    public ClienteResponseDTO getByLogin(@PathParam("login") String login) throws NotFoundException {

        return ClienteService.findByLogin(login);
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
