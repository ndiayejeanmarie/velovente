package sn.edu.ugb.ipsl.velovente.Resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import sn.edu.ugb.ipsl.velovente.services.ClientService;
import sn.edu.ugb.ipsl.velovente.model.Client;

@Path("/clients")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ClientResource {

    @EJB
    private ClientService clientService; // Injection de la façade pour les clients

    @GET
    public Response getAllClients() {
        // Utilisons la méthode de la façade pour récupérer la liste des clients
        return Response.ok(clientService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getClientById(@PathParam("id") Integer id) {
        // Utilisons la méthode de la façade pour récupérer un client par son ID
        Client client = clientService.findById(id);
        if (client != null) {
            return Response.ok(client).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addClient(Client client) {
        clientService.saveClient(client);
        return Response.status(Response.Status.CREATED).entity(client).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateClient(@PathParam("id") Integer id, Client updatedClient) {
        Client existingClient = clientService.findById(id);
        if (existingClient != null) {
            updatedClient.setId(existingClient.getId());
            clientService.updateClient(updatedClient);
            return Response.ok(updatedClient).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteClient(@PathParam("id") Integer id) {
        Client client = clientService.findById(id);
        if (client != null) {
            clientService.deleteClient(client);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
