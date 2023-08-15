package sn.edu.ugb.ipsl.velovente.mbeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import sn.edu.ugb.ipsl.velovente.model.ArticleCommande;
import sn.edu.ugb.ipsl.velovente.services.ArticleCommandeService;

import java.io.Serializable;
import java.util.List;

@Named("articleCommandeBeans")
@ViewScoped
public class ArticleCommandeBeans implements Serializable {

    @EJB
    private ArticleCommandeService articleCommandeService;

    private ArticleCommande articleCommande = new ArticleCommande();
    private List<ArticleCommande> articleCommandes;

    public ArticleCommande getArticleCommande() {
        return articleCommande;
    }

    public List<ArticleCommande> getArticleCommandes() {
        if (articleCommandes == null) {
            articleCommandes = articleCommandeService.findAll();
        }
        return articleCommandes;
    }

    public void setArticleCommande(ArticleCommande articleCommande) {
        this.articleCommande = articleCommande;
    }

    @PostConstruct
    public void init() {
        System.out.println("### Création de ArticleCommandeBeans");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("### Suppression de ArticleCommandeBeans" + articleCommande);
    }

    public void create() {
        articleCommandeService.saveArticleCommande(articleCommande);
        articleCommande = new ArticleCommande();
    }

    public void delete() {
        articleCommandeService.deleteArticleCommande(articleCommande);
    }

    public void update() {
        articleCommandeService.updateArticleCommande(articleCommande);
    }
}
