package nl.craftsmen.conference.service.quarkus;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.test.Mock;

@Mock
@ApplicationScoped
@RestClient
public class MockCountryClient implements CountryClient {

    @Override
    public Country getCountryOfConference(String name) {
        Country country = new Country();
        country.setName("Belgium");
        return country;
    }
}
