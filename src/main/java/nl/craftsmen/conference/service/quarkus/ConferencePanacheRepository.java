package nl.craftsmen.conference.service.quarkus;

import java.util.List;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class ConferencePanacheRepository {

    @Transactional
    public void save(final Conference conference) {
        conference.persist();
    }

    public List<Conference> findAll() {
        return Conference.listAll();
    }
}
