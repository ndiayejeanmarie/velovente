package sn.edu.ugb.ipsl.velovente.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sn.edu.ugb.ipsl.velovente.model.Personne;

import java.util.List;

@Stateless
public class PersonneService {
    @PersistenceContext(unitName = "veloVente_PU")
    EntityManager em;

    public void savePersonne(Personne personne){
        em.persist(personne);
    }
    public List<Personne>findAll(){
        Query q=em.createQuery("SELECT c FROM Personne c");
        return q.getResultList();
    }
    public Personne findById(long id){
        return em.find(Personne.class,id);
    }

    public  void deletePersonne(Personne personne){
        em.remove(personne);
    }
    public void updatePersonne(Personne personne){
        em.merge(personne);
    }

}
