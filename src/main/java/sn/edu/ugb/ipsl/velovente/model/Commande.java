/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.edu.ugb.ipsl.velovente.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import jakarta.persistence.*;

/**
 *
 * @author jeans
 */
@Entity
@Table(name = "commande")
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private Integer numero;
    @Basic(optional = false)
    @Column(name = "STATUT")
    private short statut;
    @Basic(optional = false)
    @Column(name = "DATE_COMMANDE")
    @Temporal(TemporalType.DATE)
    private Date dateCommande;
    @Basic(optional = false)
    @Column(name = "DATE_LIVRAISON_VOULUE")
    @Temporal(TemporalType.DATE)
    private Date dateLivraisonVoulue;
    @Column(name = "DATE_LIVRAISON")
    @Temporal(TemporalType.DATE)
    private Date dateLivraison;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    //private Collection<ArticleCommande> articleCommandeCollection;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Client clientId;
    @JoinColumn(name = "MAGASIN_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Magasin magasinId;
    @JoinColumn(name = "VENDEUR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Employe vendeurId;

    public Commande() {
    }

    public Commande(Integer numero) {
        this.numero = numero;
    }

    public Commande(short statut, Date dateCommande, Date dateLivraisonVoulue, Date dateLivraison, Client clientId, Magasin magasinId, Employe vendeurId) {
        this.statut = statut;
        this.dateCommande = dateCommande;
        this.dateLivraisonVoulue = dateLivraisonVoulue;
        this.dateLivraison = dateLivraison;
        this.clientId = clientId;
        this.magasinId = magasinId;
        this.vendeurId = vendeurId;
    }

    public Commande(Integer numero, short statut, Date dateCommande, Date dateLivraisonVoulue) {
        this.numero = numero;
        this.statut = statut;
        this.dateCommande = dateCommande;
        this.dateLivraisonVoulue = dateLivraisonVoulue;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public short getStatut() {
        return statut;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Date getDateLivraisonVoulue() {
        return dateLivraisonVoulue;
    }

    public void setDateLivraisonVoulue(Date dateLivraisonVoulue) {
        this.dateLivraisonVoulue = dateLivraisonVoulue;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }
/*
    public Collection<ArticleCommande> getArticleCommandeCollection() {
        return articleCommandeCollection;
    }

    public void setArticleCommandeCollection(Collection<ArticleCommande> articleCommandeCollection) {
        this.articleCommandeCollection = articleCommandeCollection;
    }
*/
    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Magasin getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(Magasin magasinId) {
        this.magasinId = magasinId;
    }

    public Employe getVendeurId() {
        return vendeurId;
    }

    public void setVendeurId(Employe vendeurId) {
        this.vendeurId = vendeurId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.edu.ugb.ipsl.productionvelo.model.Commande[ numero=" + numero + " ]";
    }

}
