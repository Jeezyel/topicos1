package br.unitins;

import org.junit.jupiter.api.Test;

import br.unitins.service.ClienteService;
import jakarta.inject.Inject;

public class ClienteTestes {

    @Inject
    ClienteService service;


    @Test
    public void gatAllTeste(){

        given()
          .when().get("/pessoasfisicas")
          .then()
             .statusCode(200);

    }

    
}
