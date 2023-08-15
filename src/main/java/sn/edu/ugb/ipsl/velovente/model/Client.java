/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.edu.ugb.ipsl.velovente.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.primefaces.shaded.json.JSONPropertyIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 *
 * @author jeans
 */
@Entity
@Table(name = "client")
public class Client extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "VILLE")
    private String ville;
    @Column(name = "ETAT")
    private String etat;
    @Column(name = "CODEZIP")
    private String codeZip;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }


    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCodeZip() {
        return codeZip;
    }

    public void setCodeZip(String codeZip) {
        this.codeZip = codeZip;
    }

    /*@OneToMany(mappedBy = "clientId")
    @JsonIgnore
    private Collection<Commande> commandeCollection;
*/
    public Client() {
    }

    public Client(Integer id) {
        super(id);
    }



    public Client(String adresse, String ville, String etat, String codeZip, Collection<Commande> commandeCollection) {
        this.adresse = adresse;
        this.ville = ville;
        this.etat = etat;
        this.codeZip = codeZip;
        //this.commandeCollection = commandeCollection;
    }

    public Client(Integer id, String adresse, String ville, String etat, String codeZip, Collection<Commande> commandeCollection) {
        super(id);
        this.adresse = adresse;
        this.ville = ville;
        this.etat = etat;
        this.codeZip = codeZip;
        //this.commandeCollection = commandeCollection;
    }

    public Client(Integer id, String prenom, String nom, String email, String telephone, String adresse, String ville, String etat, String codeZip, Collection<Commande> commandeCollection) {
        super(id, prenom, nom, email, telephone);
        this.adresse = adresse;
        this.ville = ville;
        this.etat = etat;
        this.codeZip = codeZip;
        //this.commandeCollection = commandeCollection;
    }

    /*public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }
*/
    @Override
    public String toString() {
        return "Client{" +super.toString()+ "adresse=" + adresse  + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(adresse, client.adresse) && Objects.equals(ville, client.ville) && Objects.equals(etat, client.etat) && Objects.equals(codeZip, client.codeZip) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresse, ville, etat, codeZip);
    }
}
