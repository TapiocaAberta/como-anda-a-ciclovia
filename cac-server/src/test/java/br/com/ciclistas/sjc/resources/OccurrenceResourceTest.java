package br.com.ciclistas.sjc.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class OccurrenceResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/occurrences")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}