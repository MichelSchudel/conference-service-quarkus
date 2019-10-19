package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PersonResourceTest {

    @Inject
    PersonResource personResource;

    @Test
    public void testPersonInternal() {
        personResource.getAllPersons();
    }
    @Test
    public void testHelloEndpoint() {
        given().when()
                .get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hi from test profile!"));
    }

    @Test
    @Transactional
    public void testPersons() {
        Person person = new Person();
        person.setName("Michel");

        given().body(person)
                .contentType("application/json")
                .when()
                .post("/persons")
                .then()
                .statusCode(204);

        given()
                .when()
                .get("/persons")
                .then()
                .extract()
                .path("[0].name")
                .equals("michel");

    }

    @Test
    public void testCountries() {
        given().when()
                .get("/countries")
                .then()
                .statusCode(200)
                .extract()
                .path("[0].name")
                .equals("Belgium");
    }
}