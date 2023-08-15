package sn.edu.ugb.ipsl.velovente.mbeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import sn.edu.ugb.ipsl.velovente.model.Client;
import sn.edu.ugb.ipsl.velovente.model.Commande;
import sn.edu.ugb.ipsl.velovente.model.Employe;
import sn.edu.ugb.ipsl.velovente.model.Magasin;
import sn.edu.ugb.ipsl.velovente.services.*;

import java.io.Serializable;
import java.util.List;

@Named("commandeBeans")
@ViewScoped
public class CommandeBeans implements Serializable {

    @EJB
    private CommandeService commandeService;
    @EJB
    private ClientService clientService;
    @EJB
    private MagasinService magasinService;
    @EJB
    private EmployeService employeService;




    private Commande commande = new Commande();
    private Integer idclient;
    private Integer idmagasin;
    private Integer idvendeur;

    public Integer getIdmagasin() {
        return idmagasin;
    }

    public void setIdmagasin(Integer idmagasin) {
        this.idmagasin = idmagasin;
    }

    public Integer getIdvendeur() {
        return idvendeur;
    }

    public void setIdvendeur(Integer idvendeur) {
        this.idvendeur = idvendeur;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    private List<Commande> commandes;

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public List<Commande> getCommandes() {
        if (commandes == null) {
            commandes = commandeService.findAll();
        }
        return commandes;
    }

    @PostConstruct
    public void init() {
        System.out.println("### Création de CommandeBeans");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("### Suppression de CommandeBeans");
    }

    public void create() {
        // Vérifier si idclient est valide avant d'appeler findById
        if (idclient != null) {
            Client client = clientService.findById(idclient);
            commande.setClientId(client);
        }

// Vérifier si idmagasin est valide avant d'appeler findById
        if (idmagasin != null) {
            Magasin magasin = magasinService.findById(idmagasin);
            commande.setMagasinId(magasin);
        }

// Vérifier si idvendeur est valide avant d'appeler findById
        if (idvendeur != null) {
            Employe vendeur = employeService.findById(idvendeur);
            commande.setVendeurId(vendeur);
        }

        // Appelez votre service ou effectuez les opérations nécessaires pour ajouter la commande à la base de données
        commandeService.saveCommande(commande);
        idclient=null;
        idmagasin=null;
        idvendeur=null;
        commande = new Commande();
    }

    public void delete() {




        commandeService.deleteCommande(commande);

    }

    public void update() {
        // Vérifier si idclient est valide avant d'appeler findById
        if (idclient != null) {
            Client client = clientService.findById(idclient);
            commande.setClientId(client);
        }

// Vérifier si idmagasin est valide avant d'appeler findById
        if (idmagasin != null) {
            Magasin magasin = magasinService.findById(idmagasin);
            commande.setMagasinId(magasin);
        }

// Vérifier si idvendeur est valide avant d'appeler findById
        if (idvendeur != null) {
            Employe vendeur = employeService.findById(idvendeur);
            commande.setVendeurId(vendeur);
        }

        commandeService.updateCommande(commande);
        idclient=null;
        idmagasin=null;
        idvendeur=null;
        commande = new Commande();
    }
}
