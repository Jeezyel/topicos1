package br.unitins;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MunicipiosTestes {

    @Test
    public void gatAllTeste(){

        given()
          .when().get("/municipios/getAll")
          .then()
             .statusCode(200);

    }

    @Test
    public void CountTeste(){

        given()
          .when().get("/municipios/count")
          .then()
            .statusCode(200);

    }
    
}
