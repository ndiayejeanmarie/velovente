package sn.edu.ugb.ipsl.velovente.mbeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import sn.edu.ugb.ipsl.velovente.model.Employe;
import sn.edu.ugb.ipsl.velovente.model.Magasin;
import sn.edu.ugb.ipsl.velovente.services.EmployeService;
import sn.edu.ugb.ipsl.velovente.services.MagasinService;

import java.io.Serializable;
import java.util.List;

@Named("employeBeans")
@ViewScoped
public class EmployeBeans implements Serializable {

    @EJB
    private EmployeService employeService;
    @EJB
    private MagasinService magasinService;
    private Employe employe = new Employe();
    private Integer idmagasin=null;
    private Integer idmanager=null;

    public Integer getIdmagasin() {
        return idmagasin;
    }

    public void setIdmagasin(Integer idmagasin) {
        this.idmagasin = idmagasin;
    }

    public Integer getIdmanager() {
        return idmanager;
    }

    public void setIdmanager(Integer idmanager) {
        this.idmanager = idmanager;
    }

    private List<Employe> employes;

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public List<Employe> getEmployes() {
        if (employes == null) {
            employes = employeService.findAll();
        }
        return employes;
    }

    @PostConstruct
    public void init() {
        System.out.println("### Création de EmployeBeans");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("#### Suppression de EmployeBeans");
    }

    public void create() {
        Magasin magasin=magasinService.findById(idmagasin);
        employe.setMagasinId(magasin);
        if (idmanager!=null){
            Employe manager=employeService.findById(idmanager);
            employe.setManagerId(manager);
        }

        employeService.saveEmploye(employe);
        employe = new Employe();
        idmanager=null;
        idmagasin=null;
    }

    public void delete() {
        employeService.deleteEmploye(employe);
    }

    public void update() {
        Magasin magasin=magasinService.findById(idmagasin);
        employe.setMagasinId(magasin);
        if (idmanager!=null){
            Employe manager=employeService.findById(idmanager);
            employe.setManagerId(manager);
        }

        employeService.updateEmploye(employe);
    }
}
