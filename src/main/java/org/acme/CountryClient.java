package org.acme;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/")
@RegisterRestClient(baseUri = "http://localhost:9000/")
public interface CountryClient {

    @GET
    @Path("/countries")
    @Produces("application/json")
    @Retry(maxRetries = 3)
    @CircuitBreaker
    List<Country> getAllCountries();
}
