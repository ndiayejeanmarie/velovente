package sn.edu.ugb.ipsl.velovente.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sn.edu.ugb.ipsl.velovente.model.Commande;

import java.util.List;

@Stateless
public class CommandeService {
    @PersistenceContext(unitName = "veloVente_PU")
    EntityManager em;

    public void saveCommande(Commande commande) {

        em.persist(commande);
    }

    public List<Commande> findAll() {
        Query q = em.createQuery("SELECT c FROM Commande c ORDER BY c.numero DESC");
        q.setMaxResults(10);
        return q.getResultList();
    }

    public Commande findByNumero(int numero) {
        return em.find(Commande.class, numero);
    }

    public void deleteCommande(Commande commande) {
        Commande c = em.find(Commande.class, commande.getNumero());
        if (c != null) {
            em.remove(c);
        }
    }

    public void updateCommande(Commande commande) {
        em.merge(commande);
    }
}
