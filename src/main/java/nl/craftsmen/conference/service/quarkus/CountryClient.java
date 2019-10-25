package nl.craftsmen.conference.service.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/")
@RegisterRestClient
public interface CountryClient {

    @GET
    @Path("/conferences/{name}/country")
    @Produces("application/json")
    @Retry(maxRetries = 3)
    @CircuitBreaker
    Country getCountryOfConference(@PathParam("name") String name);
}
