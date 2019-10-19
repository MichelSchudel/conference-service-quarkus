package org.acme;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.test.Mock;

@Mock
@ApplicationScoped
@RestClient
public class MockCountryClient implements CountryClient {

    @Override
    public List<Country> getAllCountries() {
        Country country = new Country();
        country.setName("Belgium");
        return Arrays.asList(country);
    }
}
