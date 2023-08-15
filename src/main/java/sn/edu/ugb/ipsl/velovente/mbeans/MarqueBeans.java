package sn.edu.ugb.ipsl.velovente.mbeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import sn.edu.ugb.ipsl.velovente.model.Marque;
import sn.edu.ugb.ipsl.velovente.services.MarqueService;

import java.io.Serializable;
import java.util.List;

@Named("marqueBeans")
@ViewScoped
public class MarqueBeans implements Serializable {

    @EJB
    private MarqueService marqueService;

    private Marque marque = new Marque();
    private List<Marque> marques;

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public List<Marque> getMarques() {
        if (marques == null) {
            marques = marqueService.findAll();
        }
        return marques;
    }

    public Marque getMarqueById(Integer marqueId) {
        return marqueService.findById(marqueId);
    }

    public void create() {
        marqueService.saveMarque(marque);
        marque = new Marque();
        marques = null; // Refresh the list of marques after creating a new one
    }

    public void delete() {
        marqueService.deleteMarque(marque);
        marque = new Marque();
        marques = null; // Refresh the list of marques after deleting one
    }

    public void update() {
        marqueService.updateMarque(marque);
        marque = new Marque();
        marques = null; // Refresh the list of marques after updating one
    }

    @PostConstruct
    public void init() {
        System.out.println("### Creation de MarqueBeans");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("#### Suppression de MarqueBeans");
    }
}
