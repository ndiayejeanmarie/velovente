package sn.edu.ugb.ipsl.velovente.mbeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import sn.edu.ugb.ipsl.velovente.model.Categorie;
import sn.edu.ugb.ipsl.velovente.services.CategorieService;

import java.io.Serializable;
import java.util.List;

@Named("categorieBeans")
@ViewScoped
public class CategorieBeans implements Serializable {

    @EJB
    private CategorieService categorieService;

    private Categorie categorie = new Categorie();
    private List<Categorie> categories;

    public Categorie getCategorie() {
        return categorie;
    }

    public List<Categorie> getCategories() {
        if (categories == null) {
            categories = categorieService.findAll();
        }
        return categories;
    }

    public Categorie getCategorieById(Integer categorieId) {
        return categorieService.findById(categorieId);
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @PostConstruct
    public void init() {
        System.out.println("### Création de CategorieBeans");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("### Suppression de CategorieBeans" + categorie);
    }

    public void create() {
        categorieService.saveCategorie(categorie);
        categorie = new Categorie();
    }

    public void delete() {
        categorieService.deleteCategorie(categorie);
    }

    public void update() {
        categorieService.updateCategorie(categorie);
    }
}
