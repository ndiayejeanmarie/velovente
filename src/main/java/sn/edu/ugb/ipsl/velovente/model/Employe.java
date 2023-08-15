/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.edu.ugb.ipsl.velovente.model;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author jeans
 *

 */
@Entity
@Table(name = "employe")
public class Employe extends Personne{

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ACTIF")
    private short actif;
    @JoinColumn(name = "MAGASIN_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Magasin magasinId;
    //@OneToMany(mappedBy = "managerId")
    //private Collection<Employe> employeCollection;
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "ID",nullable = true)
    @ManyToOne
    private Employe managerId;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "vendeurId")
    //private Collection<Commande> commandeCollection;

    public Employe() {
    }

    public Employe(Integer id) {
        super(id);
    }

    public Employe(short actif, Magasin magasinId, Collection<Employe> employeCollection, Employe managerId, Collection<Commande> commandeCollection) {
        this.actif = actif;
        this.magasinId = magasinId;
        //this.employeCollection = employeCollection;
        this.managerId = managerId;
        //this.commandeCollection = commandeCollection;
    }

    public Employe(Integer id, short actif, Magasin magasinId, Collection<Employe> employeCollection, Employe managerId, Collection<Commande> commandeCollection) {
        super(id);
        this.actif = actif;
        this.magasinId = magasinId;
        //this.employeCollection = employeCollection;
        this.managerId = managerId;
        //this.commandeCollection = commandeCollection;
    }


    public Employe(Integer id, String prenom, String nom, String email, String telephone, short actif, Magasin magasinId, Collection<Employe> employeCollection, Employe managerId, Collection<Commande> commandeCollection) {
        super(id, prenom, nom, email, telephone);
        this.actif = actif;
        this.magasinId = magasinId;
        //this.employeCollection = employeCollection;
        this.managerId = managerId;
        //this.commandeCollection = commandeCollection;
    }

    public short getActif() {
        return actif;
    }

    public void setActif(short actif) {
        this.actif = actif;
    }

    public Magasin getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(Magasin magasinId) {
        this.magasinId = magasinId;
    }
/*
    public Collection<Employe> getEmployeCollection() {
        return employeCollection;
    }

    public void setEmployeCollection(Collection<Employe> employeCollection) {
        this.employeCollection = employeCollection;
    }
*/
    public Employe getManagerId() {
        return managerId;
    }

    public void setManagerId(Employe managerId) {
        this.managerId = managerId;
    }
/*
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

*/
    @Override
    public String toString() {
        return "Employe{"+super.toString() +
                "actif=" + actif +
                ", magasinId=" + magasinId +
                ", managerId=" + managerId +
                '}';
    }
}
