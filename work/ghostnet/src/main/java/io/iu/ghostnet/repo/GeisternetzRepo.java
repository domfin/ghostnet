package io.iu.ghostnet.repo;

import io.iu.ghostnet.entity.Geisternetz;
import io.iu.ghostnet.entity.Status;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class GeisternetzRepo {

    @PersistenceContext
    private EntityManager em;

    public void create(Geisternetz g) {
        em.persist(g);
    }

    public Geisternetz update(Geisternetz g) {
        return em.merge(g);
    }

    public Geisternetz findById(Long id) {
        return em.find(Geisternetz.class, id);
    }

    /** Dashboard: nur GEMELDET + BEVORSTEHEND (neueste zuerst) */
    public List<Geisternetz> findForDashboard() {
        return em.createQuery(
                "SELECT g FROM Geisternetz g " +
                "WHERE g.status IN (:s1, :s2) " +
                "ORDER BY g.id DESC",
                Geisternetz.class)
            .setParameter("s1", Status.GEMELDET)
            .setParameter("s2", Status.BEVORSTEHEND)
            .getResultList();
    }
}
