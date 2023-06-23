package br.unitins.resouce;

//import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.aplication.Result;
import br.unitins.dto.ClienteDTO;
import br.unitins.dto.ClienteResponseDTO;
import br.unitins.dto.ClienteSimplesDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.form.ImageForm;
import br.unitins.service.ClienteService;
import br.unitins.service.FileService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Null;

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

    private static final Logger LOG = Logger.getLogger(ClienteResouce.class);

    @Inject
    ClienteService clienteService;

    @Inject
    JsonWebToken tokenJwt;

    @Inject
    FileService fileService;
    /*
     * @GET
     * 
     * @Path("/dados-pessoais")
     * 
     * @RolesAllowed({ "User" })
     * public Response getDadosPessoais() {
     * 
     * String login = tokenJwt.getSubject();
     * 
     * Usuario usuario = usuarioService.getByLoginUsuario(login);
     * 
     * UsuarioResponseDTO dadosPessoaisUsuario = new UsuarioResponseDTO(usuario);
     * 
     * return Response.ok(dadosPessoaisUsuario).build();
     * }
     */

    @GET
    @Path("/getCliente-log")
    @RolesAllowed({ "Admin", "User", "Cliente" })
    public ClienteResponseDTO getUsuario() {

        LOG.info("obtendo o login a partir do token");
        String login = tokenJwt.getSubject();
        LOG.info(" procurando pro login");

        ClienteResponseDTO usuario = clienteService.findByLogin(login);

        return usuario;
    }

    @PATCH
    @Path("/novaimagem")
    @RolesAllowed({ "Admin", "User", "Cliente" })
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ImageForm form ) {
        LOG.info(" savando imagem ");

        String nomeImagem = "";

        try {
            LOG.info("dentro do try de savando imagem ");
            nomeImagem = fileService.salvarImagemUsuario(form.getImagem(), form.getNomeImagem());
        } catch (IOException e) {
            LOG.info("erro em savando imagem ");
            LOG.info(e.getMessage());
            Result result = new Result(e.getMessage());
            return Response.status(Status.CONFLICT).entity(result).build();
        }

        // obtendo o login a partir do token
        

        String login = tokenJwt.getSubject();
        
        ClienteResponseDTO usuario = clienteService.findByLogin(login); 

        usuario = clienteService.updateNomeImagen(usuario.id(), nomeImagem);

        return Response.ok(usuario).build();

    }

    @GET
    @Path("/download/{nomeImagem}")
    @RolesAllowed({ "Admin", "User", "Cliente" })
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {

        try {
            LOG.info(" fazendo download da imagem");
            ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
            response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
            return response.build();

        } catch (Exception e) {
            LOG.fatal("erro não planejado");
            Result result = new Result(e.getMessage());

            return Response
                    .status(Status.CONFLICT)
                    .entity(result)
                    .build();
        }

    }

    @GET
    @Path("/getall")
    @RolesAllowed({ "Admin" })
    public List<ClienteResponseDTO> getAll() {
        LOG.info(" pagando todos os cliente");
        return clienteService.getAll();
    }

    @GET
    @Path("/usuario-logado")
    @RolesAllowed({ "Admin" })
    public ClienteResponseDTO usuarioLogado() {
        LOG.info(" pegando usuari logado ");
        String login = tokenJwt.getSubject();
        return clienteService.findByLogin(login);
    }

    @POST
    @Path("/insert")
    @RolesAllowed({ "Admin", "User", "Cliente" })
    public Response insert(ClienteDTO clienteDTO) {

        try {
            LOG.info(" criando um cliente ");
            return Response
                    .status(Status.CREATED) // 201
                    .entity(clienteService.create(clienteDTO))
                    .build();
        } catch (ConstraintViolationException e) {
            LOG.debug(" erro na ciração");
            Result result = new Result(e.getConstraintViolations());

            return Response
                    .status(Status.NOT_FOUND)
                    .entity(result)
                    .build();
        } catch (Exception e) {
            LOG.fatal(" erro na planejado");
            Result result = new Result(e.getMessage());

            return Response
                    .status(Status.NOT_FOUND)
                    .entity(result)
                    .build();
        }
    }

    @DELETE
    @Path("/delete{login}")
    @RolesAllowed({ "Admin", "Cliente" })
    public Response delete(@PathParam("login") String login) throws IllegalArgumentException, NotFoundException {

        clienteService.deleteByLogin(login);
        LOG.info(" apagando pelo login");
        return Response
                .status(Status.NO_CONTENT)
                .build();
    }

    @PUT
    @Path("/update{login}")
    @RolesAllowed({ "Admin" })
    public Boolean updatUsuario(@PathParam("login") String login, ClienteDTO clienteDTO) {

        try {
            LOG.info("criando o cliente");
            clienteService.update(login, clienteDTO);
            return true;
        } catch (Exception e) {
            LOG.fatal("erro não planejado");
            return false;
        }

    }

    @GET
    @Path("/getbylogin{login}")
    @RolesAllowed({ "Admin" })
    public ClienteResponseDTO getByLogin(@PathParam("login") String login) throws NotFoundException {
        LOG.info(" procurando por login");
        return clienteService.findByLogin(login);
    }

    @PUT
    @Path("/atualizar-senha")
    @RolesAllowed({ "Admin","Cliente" ,"Usuario"})
    public Boolean atualizarSenha(String novaSenha, String velhaSenha) {
        LOG.info("pegando o login");

        String login = tokenJwt.getSubject();

        try {
            LOG.info("atualizando a senha do cliente");

            return clienteService.alterarSenha(login, novaSenha, velhaSenha);
        } catch (NullPointerException e) {
            LOG.debug("erro cliente n encontrado");
            return false;
        } catch (Exception e) {
            LOG.fatal("erro não planejado");
            return false;
        }

    }

    @POST
    @Transactional
    @Path("/usuario-simples")
    public Boolean usuarioSimples(ClienteSimplesDTO clienteSimplesDTO) throws Exception {
        LOG.info("criando o usuario simples");
        try {
            LOG.info("criando o usuario simples dentor do try");
            clienteService.createSimplis(clienteSimplesDTO);
            return true;

        } catch (Exception e) {
            LOG.fatal("erro não planejado");
            return false;
        }

        

    }

    @GET
    @Path("/teste-patuver")
    public String teste()  {
        String login = tokenJwt.getSubject();

        return login;

        

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    
/*
    @PATCH
    @Path("/novaimagemmmmm")
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
        ClienteResponseDTO usuario = clienteService.findByLogin(login);

        usuario = clienteService.updateNomeImagen(usuario.id(), nomeImagem);

        return Response.ok(usuario).build();

    }

    @GET
    @Path("/downloaddd/{nomeImagem}")
    @RolesAllowed({"Admin","User"})
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloaddd(@PathParam("nomeImagem") String nomeImagem) {
        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment;filename="+nomeImagem);
        return response.build();
    }
    


    
     * @Inject
     * JsonWebToken token;
     * 
     * @Inject
     * ClienteService service;
     * 
     * 
     * public Response getCliente(){
     * String logado = token.getSubject();
     * ClienteResponseDTO cliente = service.findByLogado(logado);
     * 
     * return Response.ok().build();
     * }
     */
}
