package sn.edu.ugb.ipsl.velovente.Resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import sn.edu.ugb.ipsl.velovente.services.CategorieService;
import sn.edu.ugb.ipsl.velovente.model.Categorie;

@Path("/categories")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CategorieResource {

    @EJB
    private CategorieService categorieService;

    @GET
    public Response getAllCategories() {
        return Response.ok(categorieService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getCategorieById(@PathParam("id") Integer id) {
        Categorie categorie = categorieService.findById(id);
        if (categorie != null) {
            return Response.ok(categorie).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addCategorie(Categorie categorie) {
        categorieService.saveCategorie(categorie);
        return Response.status(Response.Status.CREATED).entity(categorie).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateCategorie(@PathParam("id") Integer id, Categorie updatedCategorie) {
        Categorie existingCategorie = categorieService.findById(id);
        if (existingCategorie != null) {
            updatedCategorie.setId(existingCategorie.getId());
            categorieService.updateCategorie(updatedCategorie);
            return Response.ok(updatedCategorie).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCategorie(@PathParam("id") Integer id) {
        Categorie categorie = categorieService.findById(id);
        if (categorie != null) {
            categorieService.deleteCategorie(categorie);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
