package sn.edu.ugb.ipsl.velovente.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sn.edu.ugb.ipsl.velovente.model.Categorie;

import java.util.List;

@Stateless
public class CategorieService {
    @PersistenceContext(unitName = "veloVente_PU")
    EntityManager em;

    public void saveCategorie(Categorie categorie){
        em.persist(categorie);
    }
    public List<Categorie>findAll(){
        Query q=em.createQuery("SELECT c FROM Categorie c");
        return q.getResultList();
    }
    public Categorie findById(Integer id){
        return em.find(Categorie.class,id);
    }

    public  void deleteCategorie(Categorie categorie){
        Categorie c = em.find(Categorie.class,categorie.getId());
        if (c!=null){
            em.remove(c);
        }
    }
    public void updateCategorie(Categorie categorie){
        em.merge(categorie);
    }

}
