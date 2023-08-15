package sn.edu.ugb.ipsl.velovente.mbeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import sn.edu.ugb.ipsl.velovente.model.Produit;
import sn.edu.ugb.ipsl.velovente.services.CategorieService;
import sn.edu.ugb.ipsl.velovente.services.MarqueService;
import sn.edu.ugb.ipsl.velovente.services.ProduitService;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named("produitBeans")
@ViewScoped
public class ProduitBeans implements Serializable {

    @EJB
    private ProduitService produitService;

    @EJB
    private CategorieService categorieService;

    @EJB
    private MarqueService marqueService;

    private Produit produit = new Produit();
    private Integer idCategorie = null;
    private Integer idMarque = null;

    private List<Produit> produits;

    private String nomProduit;
    private String nomMarque;
    private String nomCategorie;
    private BigDecimal prixMin;
    private BigDecimal prixMax;

    private List<Produit> produitsRecherches;

    public String getNomProduit() {
        return nomProduit;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public BigDecimal getPrixMin() {
        return prixMin;
    }

    public BigDecimal getPrixMax() {
        return prixMax;
    }

    public List<Produit> getProduitsRecherches() {
        return produitsRecherches;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
        this.idCategorie = produit.getCategorieId().getId();
        this.idMarque = produit.getMarqueId().getId();
    }

    public List<Produit> getProduits() {
        if (produits == null) {
            produits = produitService.findAll();
        }
        return produits;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Integer getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public void setPrixMin(BigDecimal prixMin) {
        this.prixMin = prixMin;
    }

    public void setPrixMax(BigDecimal prixMax) {
        this.prixMax = prixMax;
    }

    public void setProduitsRecherches(List<Produit> produitsRecherches) {
        this.produitsRecherches = produitsRecherches;
    }

    @PostConstruct
    public void init() {
        System.out.println("### Création de ProduitBeans");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("#### Suppression de ProduitBeans");
    }

    public void create() {
        produit.setCategorieId(categorieService.findById(idCategorie));
        produit.setMarqueId(marqueService.findById(idMarque));

        produitService.saveProduit(produit);
        produit = new Produit();
        idCategorie = null;
        idMarque = null;
    }

    public void delete() {
        produitService.deleteProduit(produit);
    }

    public void update() {
        if (produit.getCategorieId().getId() != idCategorie) {
            produit.setCategorieId(categorieService.findById(idCategorie));
        }

        if (produit.getMarqueId().getId() != idMarque) {
            produit.setMarqueId(marqueService.findById(idMarque));
        }
        produitService.updateProduit(produit);
    }
    public void search(){
        produitsRecherches=produitService.rechercheAvancee(nomProduit,nomMarque,nomCategorie,prixMin,prixMax);
    }
}
