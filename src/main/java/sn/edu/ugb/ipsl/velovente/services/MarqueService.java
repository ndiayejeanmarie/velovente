package sn.edu.ugb.ipsl.velovente.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sn.edu.ugb.ipsl.velovente.model.Marque;

import java.util.List;

@Stateless
public class MarqueService {
    @PersistenceContext(unitName = "veloVente_PU")
    EntityManager em;

    public void saveMarque(Marque marque){
        em.persist(marque);
    }
    public List<Marque>findAll(){
        Query q=em.createQuery("SELECT c FROM Marque c");
        return q.getResultList();
    }
    public Marque findById(Integer id){
        return em.find(Marque.class,id);
    }

    public  void deleteMarque(Marque marque){
        Marque m=em.find(Marque.class,marque.getId());
        if (m!=null) {
            em.remove(m);
        }
    }
    public void updateMarque(Marque marque){
        em.merge(marque);
    }

}
