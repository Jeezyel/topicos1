package br.unitins;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class EnderecotTestes {

    @Test
    public void gatAllTeste(){

        given()
          .when().get("/endereco/getAll")
          .then()
             .statusCode(200);

    }

    @Test
    public void CountTeste(){

        given()
          .when().get("/endereco/count")
          .then()
            .statusCode(200);

    }
    
}
