/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.edu.ugb.ipsl.velovente.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author jeans
 */
@Embeddable
public class StockPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "MAGASIN_ID")
    private int magasinId;
    @Basic(optional = false)
    @Column(name = "PRODUIT_ID")
    private int produitId;

    public StockPK() {
    }

    public StockPK(int magasinId, int produitId) {
        this.magasinId = magasinId;
        this.produitId = produitId;
    }

    public int getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(int magasinId) {
        this.magasinId = magasinId;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) magasinId;
        hash += (int) produitId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockPK)) {
            return false;
        }
        StockPK other = (StockPK) object;
        if (this.magasinId != other.magasinId) {
            return false;
        }
        if (this.produitId != other.produitId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.edu.ugb.ipsl.velovente.model.StockPK[ magasinId=" + magasinId + ", produitId=" + produitId + " ]";
    }

}
