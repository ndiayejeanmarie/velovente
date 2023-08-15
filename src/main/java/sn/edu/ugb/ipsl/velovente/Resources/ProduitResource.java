package sn.edu.ugb.ipsl.velovente.Resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import sn.edu.ugb.ipsl.velovente.services.ProduitService;
import sn.edu.ugb.ipsl.velovente.model.Produit;

@Path("/produits")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ProduitResource {

    @EJB
    private ProduitService produitService; // Injection de la façade pour les produits

    @GET
    public Response getAllProduits() {
        // Récupérer la liste de tous les produits
        return Response.ok(produitService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getProduitById(@PathParam("id") Integer id) {
        // Récupérer un produit par son ID
        Produit produit = produitService.findById(id);
        if (produit != null) {
            return Response.ok(produit).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addProduit(Produit produit) {
        // Ajouter un nouveau produit
        produitService.saveProduit(produit);
        return Response.status(Response.Status.CREATED).entity(produit).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduit(@PathParam("id") Integer id, Produit updatedProduit) {
        // Mettre à jour un produit par son ID
        Produit existingProduit = produitService.findById(id);
        if (existingProduit != null) {
            updatedProduit.setId(existingProduit.getId());
            produitService.updateProduit(updatedProduit);
            return Response.ok(updatedProduit).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduit(@PathParam("id") Integer id) {
        // Supprimer un produit par son ID
        Produit produit = produitService.findById(id);
        if (produit != null) {
            produitService.deleteProduit(produit);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
