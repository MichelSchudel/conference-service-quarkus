package nl.craftsmen.conference.service.quarkus;

import java.util.List;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class ConferencePanacheRepository {

    @Transactional
    public void create(final Conference person) {
        person.persist();
    }

    public List<Conference> getAll() {
        return Conference.listAll();
    }
}
