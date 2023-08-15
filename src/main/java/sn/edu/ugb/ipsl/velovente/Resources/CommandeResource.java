package sn.edu.ugb.ipsl.velovente.Resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import sn.edu.ugb.ipsl.velovente.services.CommandeService;
import sn.edu.ugb.ipsl.velovente.model.Commande;

@Path("/commandes")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CommandeResource {

    @EJB
    private CommandeService commandeService;

    @GET
    public Response getAllCommandes() {
        return Response.ok(commandeService.findAll()).build();
    }

    @GET
    @Path("/{numero}")
    public Response getCommandeByNumero(@PathParam("numero") int numero) {
        Commande commande = commandeService.findByNumero(numero);
        if (commande != null) {
            return Response.ok(commande).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addCommande(Commande commande) {
        commandeService.saveCommande(commande);
        return Response.status(Response.Status.CREATED).entity(commande).build();
    }

    @PUT
    @Path("/{numero}")
    public Response updateCommande(@PathParam("numero") int numero, Commande updatedCommande) {
        Commande existingCommande = commandeService.findByNumero(numero);
        if (existingCommande != null) {
            updatedCommande.setNumero(existingCommande.getNumero());
            commandeService.updateCommande(updatedCommande);
            return Response.ok(updatedCommande).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{numero}")
    public Response deleteCommande(@PathParam("numero") int numero) {
        Commande commande = commandeService.findByNumero(numero);
        if (commande != null) {
            commandeService.deleteCommande(commande);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
