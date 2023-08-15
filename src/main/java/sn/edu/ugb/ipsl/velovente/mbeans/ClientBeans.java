package sn.edu.ugb.ipsl.velovente.mbeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import sn.edu.ugb.ipsl.velovente.model.Client;
import sn.edu.ugb.ipsl.velovente.services.ClientService;


import java.io.Serializable;
import java.util.List;

@Named("clientBeans")
@ViewScoped
public class ClientBeans implements Serializable {

    @EJB
    private ClientService clientService;

    private Client client=new Client();
    private List<Client> clients;

    public Client getClient(){return client;}

    public List<Client> getClients() {
        if (clients==null){
            clients= clientService.findAll();
        }
        return clients;
    }
    public Client getClientById(Integer clientId) {
        return clientService.findById(clientId);
    }

    public void setClient(Client client){this.client=client;}

    @PostConstruct
    public void  init(){
        System.out.println("### creation de ClientBeans");

    }
    @PreDestroy
    public void destroy(){
        System.out.println("####Suppresion de ajoutClientBeans"+client);
    }

    public void create(){
        clientService.saveClient(client);
        client=new Client();
    }
    public String  delete(){
        clientService.deleteClient(client);

        return "/client/list-clients.xhtml?faces-redirect=true";


    }
    public void update(){
        clientService.updateClient(client);
    }

}

