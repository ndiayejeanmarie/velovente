package sn.edu.ugb.ipsl.velovente.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sn.edu.ugb.ipsl.velovente.model.Stock;
import sn.edu.ugb.ipsl.velovente.model.StockPK;

import java.util.List;

@Stateless
public class StockService {
    @PersistenceContext(unitName = "veloVente_PU")
    EntityManager em;

    public void saveStock(Stock stock){
        em.persist(stock);
    }
    public List<Stock>findAll(){
        Query q=em.createQuery("SELECT c FROM Stock c");
        return q.getResultList();
    }
    public Stock findById(Integer idmagasin,Integer idproduit){
        StockPK pk= new StockPK(idmagasin,idproduit);
        return em.find(Stock.class,pk);
    }

    public  void deleteStock(Stock stock){
        Stock s = em.find(Stock.class,stock.getStockPK());
        if (s!=null) {
            em.remove(s);
        }
    }
    public void updateStock(Stock stock){
        em.merge(stock);
    }

}
