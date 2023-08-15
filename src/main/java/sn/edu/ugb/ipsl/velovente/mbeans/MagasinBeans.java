package sn.edu.ugb.ipsl.velovente.mbeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import sn.edu.ugb.ipsl.velovente.model.Magasin;
import sn.edu.ugb.ipsl.velovente.services.MagasinService;

import java.io.Serializable;
import java.util.List;

@Named("magasinBeans")
@ViewScoped
public class MagasinBeans implements Serializable {

    @EJB
    private MagasinService magasinService;

    private Magasin magasin = new Magasin();
    private List<Magasin> magasins;

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public List<Magasin> getMagasins() {
        if (magasins == null) {
            magasins = magasinService.findAll();
        }
        return magasins;
    }

    public Magasin getMagasinById(Integer magasinId) {
        return magasinService.findById(magasinId);
    }

    @PostConstruct
    public void init() {
        System.out.println("### Création de MagasinBeans");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("### Suppression de MagasinBeans" + magasin);
    }

    public void create() {
        magasinService.saveMagasin(magasin);
        magasin = new Magasin();
    }

    public String delete() {
        magasinService.deleteMagasin(magasin);
        magasin = new Magasin();
        return "/magasin/list-magasins.xhtml?faces-redirect=true";

    }

    public void update() {
        magasinService.updateMagasin(magasin);
    }
}
