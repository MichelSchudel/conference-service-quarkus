package org.acme;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PersonService {

    @Inject
    //private PersonRepository personRepository;
    private PersonPanacheRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }

    public void createPerson(Person person) {
        personRepository.createPerson(person);

    }
}
