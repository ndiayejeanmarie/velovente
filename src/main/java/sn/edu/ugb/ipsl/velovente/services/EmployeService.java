package sn.edu.ugb.ipsl.velovente.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sn.edu.ugb.ipsl.velovente.model.Employe;

import java.util.List;

@Stateless
public class EmployeService {
    @PersistenceContext(unitName = "veloVente_PU")
    EntityManager em;

    public void saveEmploye(Employe employe){
        em.persist(employe);
    }
    public List<Employe>findAll(){
        Query q=em.createQuery("SELECT c FROM Employe c");
        return q.getResultList();
    }
    public Employe findById(Integer id){
        return em.find(Employe.class,id);
    }

    public  void deleteEmploye(Employe employe){
        Employe e= em.find(Employe.class, employe.getId());
        if(e!=null){
            em.remove(e);
        }

    }
    public void updateEmploye(Employe employe){
        em.merge(employe);
    }

}
