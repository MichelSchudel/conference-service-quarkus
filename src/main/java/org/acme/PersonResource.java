package org.acme;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/")
public class PersonResource {

    @Inject
    PersonService personService;

    @ConfigProperty(name = "quarkus.hellomessage")
    String helloMessage;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return helloMessage;
    }

    @GET
    @Path("/persons")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }


    @POST
    @Path("/persons")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPerson(Person person) {
        personService.createPerson(person);

    }
}