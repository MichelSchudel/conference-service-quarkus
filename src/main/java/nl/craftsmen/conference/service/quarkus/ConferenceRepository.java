package nl.craftsmen.conference.service.quarkus;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Singleton
public class ConferenceRepository {

    @Inject
    EntityManager entityManager;

    @Transactional
    public void create(final Conference conference) {
        entityManager.persist(conference);
    }

    public List<Conference> getAll() {
        TypedQuery<Conference> query = entityManager.createQuery("select c from Conference c", Conference.class);
        return query.getResultList();
    }
}
