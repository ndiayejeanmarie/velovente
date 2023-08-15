package sn.edu.ugb.ipsl.velovente.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sn.edu.ugb.ipsl.velovente.model.ArticleCommande;
import sn.edu.ugb.ipsl.velovente.model.ArticleCommandePK;

import java.util.List;

@Stateless
public class ArticleCommandeService {
    @PersistenceContext(unitName = "veloVente_PU")
    EntityManager em;

    public void saveArticleCommande(ArticleCommande articleCommande) {
        em.persist(articleCommande);
    }

    public List<ArticleCommande> findAll() {
        Query q = em.createQuery("SELECT ac FROM ArticleCommande ac ORDER BY ac.articleCommandePK.numeroCommande DESC");
        q.setMaxResults(10);
        return q.getResultList();
    }

    public ArticleCommande findById(Integer numerocommande,Integer numeroLigne) {
        ArticleCommandePK pk = new ArticleCommandePK(numerocommande,numeroLigne);
        return em.find(ArticleCommande.class, pk);
    }

    public void deleteArticleCommande(ArticleCommande articleCommande) {
        ArticleCommande ac = em.find(ArticleCommande.class, articleCommande.getArticleCommandePK());
        if (ac != null) {
            em.remove(ac);
        }
    }

    public void updateArticleCommande(ArticleCommande articleCommande) {
        em.merge(articleCommande);
    }
}
