package br.com.automacao;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class DogApiTest {
    
    @Test    @Order(1)
    public void Breeds_List() {
        given()
            .header("Content-Type", "application/json")
        .when()
            .get("https://dog.ceo/api/breeds/list/all")
        .then()
            .statusCode(200);
    }
    @Test    @Order(2)
    public void Breeds_Images() {
        given()
            .header("Content-Type", "application/json")
        .when()
            .get("https://dog.ceo/api/breed/hound/images")
        .then()
            .statusCode(200);
    }
    @Test    @Order(3)
    public void Breeds_Images_Random() {
        given()
            .header("Content-Type", "application/json")
        .when()
            .get("https://dog.ceo/api/breed/hound/images/random")
        .then()
            .statusCode(200);
    }
}