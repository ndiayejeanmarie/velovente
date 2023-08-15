package sn.edu.ugb.ipsl.velovente.services;

import jakarta.ejb.Stateless;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sn.edu.ugb.ipsl.velovente.model.Client;

import java.util.List;


@Stateless
public class ClientService {
    @PersistenceContext(unitName = "veloVente_PU")
    EntityManager em;

    public void saveClient(Client client){
        em.persist(client);
    }
    public List<Client>findAll(){
        Query q=em.createQuery("SELECT c FROM Client c ORDER BY c.id DESC");
        q.setMaxResults(10);
        return q.getResultList();
    }
    public Client findById(Integer id){
        return em.find(Client.class,id);
    }

    public  void deleteClient(Client client){
        Client c=em.find(Client.class,client.getId());
        if (c!= null) {
            em.remove(c);
        }

    }
    public void updateClient(Client client){
        em.merge(client);
    }

}
