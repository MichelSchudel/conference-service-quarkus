package org.acme;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Singleton
public class PersonPanacheRepository {

    @Transactional
    public void createPerson(final Person person) {
        person.persist();
    }

    public List<Person> getAllPersons() {
        return Person.listAll();
    }
}
