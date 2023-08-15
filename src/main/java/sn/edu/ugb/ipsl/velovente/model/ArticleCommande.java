/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.edu.ugb.ipsl.velovente.model;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author jeans
 */
@Entity
@Table(name = "article_commande")
public class ArticleCommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArticleCommandePK articleCommandePK;
    @Basic(optional = false)
    @Column(name = "PRODUIT_ID")
    private int produitId;
    @Basic(optional = false)
    @Column(name = "QUANTITE")
    private int quantite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRIX_DEPART")
    private BigDecimal prixDepart;
    @Basic(optional = false)
    @Column(name = "REMISE")
    private BigDecimal remise;
    @JoinColumn(name = "NUMERO_COMMANDE", referencedColumnName = "NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;

    public ArticleCommande() {
    }

    public ArticleCommande(ArticleCommandePK articleCommandePK) {
        this.articleCommandePK = articleCommandePK;
    }

    public ArticleCommande(ArticleCommandePK articleCommandePK, int produitId, int quantite, BigDecimal prixDepart, BigDecimal remise) {
        this.articleCommandePK = articleCommandePK;
        this.produitId = produitId;
        this.quantite = quantite;
        this.prixDepart = prixDepart;
        this.remise = remise;
    }

    public ArticleCommande(int numeroCommande, int ligne) {
        this.articleCommandePK = new ArticleCommandePK(numeroCommande, ligne);
    }

    public ArticleCommandePK getArticleCommandePK() {
        return articleCommandePK;
    }

    public void setArticleCommandePK(ArticleCommandePK articleCommandePK) {
        this.articleCommandePK = articleCommandePK;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(BigDecimal prixDepart) {
        this.prixDepart = prixDepart;
    }

    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articleCommandePK != null ? articleCommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleCommande)) {
            return false;
        }
        ArticleCommande other = (ArticleCommande) object;
        if ((this.articleCommandePK == null && other.articleCommandePK != null) || (this.articleCommandePK != null && !this.articleCommandePK.equals(other.articleCommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.edu.ugb.ipsl.productionvelo.model.ArticleCommande[ articleCommandePK=" + articleCommandePK + " ]";
    }
}
