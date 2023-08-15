/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.edu.ugb.ipsl.velovente.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import jakarta.persistence.*;

/**
 *
 * @author jeans
 */
@Entity
@Table(name = "produit")
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @Column(name = "ANNEE_MODEL")
    private short anneeModel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRIX_DEPART")
    private BigDecimal prixDepart;
    @JoinColumn(name = "CATEGORIE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Categorie categorieId;
    @JoinColumn(name = "MARQUE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Marque marqueId;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    //private Collection<Stock> stockCollection;

    public Produit() {
    }

    public Produit(Integer id) {
        this.id = id;
    }

    public Produit(Integer id, String nom, short anneeModel, BigDecimal prixDepart) {
        this.id = id;
        this.nom = nom;
        this.anneeModel = anneeModel;
        this.prixDepart = prixDepart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public short getAnneeModel() {
        return anneeModel;
    }

    public void setAnneeModel(short anneeModel) {
        this.anneeModel = anneeModel;
    }

    public BigDecimal getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(BigDecimal prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Categorie getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Categorie categorieId) {
        this.categorieId = categorieId;
    }

    public Marque getMarqueId() {
        return marqueId;
    }

    public void setMarqueId(Marque marqueId) {
        this.marqueId = marqueId;
    }
/*
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit{" + "id= " + id + ", nom= " + nom + '}';
    }



}
