package sn.edu.ugb.ipsl.velovente.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sn.edu.ugb.ipsl.velovente.model.Magasin;

import java.util.List;

@Stateless
public class MagasinService {
    @PersistenceContext(unitName = "veloVente_PU")
    EntityManager em;

    public void saveMagasin(Magasin magasin){
        em.persist(magasin);
    }
    public List<Magasin>findAll(){
        Query q=em.createQuery("SELECT c FROM Magasin c");
        return q.getResultList();
    }
    public Magasin findById(Integer id){
        return em.find(Magasin.class,id);
    }

    public  void deleteMagasin(Magasin magasin){
        Magasin m=em.find(Magasin.class,magasin.getId());
        if(m!=null) {
            em.remove(m);
        }
        }
    public void updateMagasin(Magasin magasin){
        em.merge(magasin);
    }

}
