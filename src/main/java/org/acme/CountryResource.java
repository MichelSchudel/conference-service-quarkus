package org.acme;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/")
public class CountryResource {


    @Inject
    @RestClient
    CountryClient countryClient;

    @GET
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)
    @Fallback(fallbackMethod = "fallback")

    public List<Country> getAllCountries() {
        return countryClient.getAllCountries();
    }


    List<Country> fallback() {
        return Collections.emptyList();
    }
}