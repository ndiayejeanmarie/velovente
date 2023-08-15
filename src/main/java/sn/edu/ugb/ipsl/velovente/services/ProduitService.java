package sn.edu.ugb.ipsl.velovente.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sn.edu.ugb.ipsl.velovente.model.Produit;

import java.math.BigDecimal;
import java.util.List;

@Stateless
public class ProduitService {
    @PersistenceContext(unitName = "veloVente_PU")
    EntityManager em;

    public void saveProduit(Produit produit){
        em.persist(produit);
    }
    public List<Produit>findAll(){
        Query q=em.createQuery("SELECT c FROM Produit c");
        return q.getResultList();
    }
    public Produit findById(Integer id){
        return em.find(Produit.class,id);
    }

    public  void deleteProduit(Produit produit){
        Produit p=em.find(Produit.class,produit.getId());
        if (p!=null){
        em.remove(p);
        }
    }
    public void updateProduit(Produit produit){
        em.merge(produit);
    }

    public List<Produit> rechercheAvancee(String nomProduit, String nomMarque, String nomCategorie, BigDecimal prixMin, BigDecimal prixMax) {
        String jpql = "SELECT p FROM Produit p WHERE p.nom LIKE '%' " + nomProduit+"'%'";

        if (nomProduit != null && !nomProduit.isEmpty()) {
            jpql += " AND p.nom LIKE '%'+nomProduit+'%'";
        }
        if (nomMarque != null && !nomMarque.isEmpty()) {
            jpql += " AND p.marqueId.nom LIKE '%'+nomMarque+'%'";
        }
        if (nomCategorie != null && !nomCategorie.isEmpty()) {
            jpql += " AND p.categorieId.nom LIKE '%'+nomCategorie+'%'";
        }
        if (prixMin != null) {
            jpql += " AND p.prixDepart >= +prixMin";
        }
        if (prixMax != null) {
            jpql += " AND p.prixDepart <= +prixMax";
        }

        Query query = em.createQuery(jpql);


        if (nomProduit != null && !nomProduit.isEmpty()) {
            query.setParameter("nomProduit", "%" + nomProduit + "%");
        }
        if (nomMarque != null && !nomMarque.isEmpty()) {
            query.setParameter("nomMarque", "%" + nomMarque + "%");
        }
        if (nomCategorie != null && !nomCategorie.isEmpty()) {
            query.setParameter("nomCategorie", "%" + nomCategorie + "%");
        }
        if (prixMin != null) {
            query.setParameter("prixMin", prixMin);
        }
        if (prixMax != null) {
            query.setParameter("prixMax", prixMax);
        }
        return query.getResultList();
    }


}
