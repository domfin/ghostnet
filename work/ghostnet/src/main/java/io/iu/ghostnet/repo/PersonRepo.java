package io.iu.ghostnet.repo;

import io.iu.ghostnet.entity.Person;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class PersonRepo {

    @PersistenceContext(unitName = "ghostnetPU")
    private EntityManager em;

    public void create(Person p) {
        em.persist(p);
    }

    public Person findById(Long id) {
        return (id == null) ? null : em.find(Person.class, id);
    }

    public List<Person> findAll() {
        return em.createQuery("SELECT p FROM Person p ORDER BY p.name", Person.class)
                 .getResultList();
    }

    public List<Person> findAllBergende() {
        return em.createQuery("SELECT p FROM Person p WHERE p.bergende = true ORDER BY p.name",
                              Person.class)
                 .getResultList();
    }
}
