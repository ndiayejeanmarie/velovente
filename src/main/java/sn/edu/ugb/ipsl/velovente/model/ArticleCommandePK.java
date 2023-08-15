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
public class ArticleCommandePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NUMERO_COMMANDE")
    private int numeroCommande;
    @Basic(optional = false)
    @Column(name = "LIGNE")
    private int ligne;

    public ArticleCommandePK() {
    }

    public ArticleCommandePK(int numeroCommande, int ligne) {
        this.numeroCommande = numeroCommande;
        this.ligne = ligne;
    }

    public int getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroCommande;
        hash += (int) ligne;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleCommandePK)) {
            return false;
        }
        ArticleCommandePK other = (ArticleCommandePK) object;
        if (this.numeroCommande != other.numeroCommande) {
            return false;
        }
        if (this.ligne != other.ligne) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.edu.ugb.ipsl.productionvelo.model.ArticleCommandePK[ numeroCommande=" + numeroCommande + ", ligne=" + ligne + " ]";
    }
    
}
