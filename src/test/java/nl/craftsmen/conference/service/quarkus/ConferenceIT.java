package nl.craftsmen.conference.service.quarkus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ConferenceIT {

    @Inject
    ConferenceResource conferenceResource;

    @Test
    public void testConferenceInternal() {
        conferenceResource.getAll();
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
    public void testGetConferences() {
        Conference conference = new Conference();
        conference.setName("Devoxx");

        given().body(conference)
                .contentType("application/json")
                .when()
                .post("/conferences")
                .then()
                .statusCode(204);

        given()
                .when()
                .get("/conferences")
                .then()
                .extract()
                .path("[0].name")
                .equals("Devoxx");

    }

    @Test
    public void testConferencesWithCountry() {
        Conference conference = new Conference();
        conference.setName("Devoxx");

        given().body(conference)
                .contentType("application/json")
                .when()
                .post("/conferences")
                .then()
                .statusCode(204);

        given().when()
                .get("/conferenceswithcountry")
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .path("[0].countryName")
                .equals("Belgium");
    }
}