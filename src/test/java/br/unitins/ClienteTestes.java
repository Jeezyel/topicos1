package br.unitins;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import br.unitins.service.ClienteService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class ClienteTestes {

    @Inject
    ClienteService service;


    @Test
    public void gatAllTeste(){

        given()
          .when().get("/cliente/gatAll")
          .then()
             .statusCode(200);

    }

    
}
