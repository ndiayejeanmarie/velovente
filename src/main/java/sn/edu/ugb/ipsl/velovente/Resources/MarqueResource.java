package sn.edu.ugb.ipsl.velovente.Resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import sn.edu.ugb.ipsl.velovente.services.MarqueService;
import sn.edu.ugb.ipsl.velovente.model.Marque;

@Path("/marques")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class MarqueResource {

    @EJB
    private MarqueService marqueService;

    @GET
    public Response getAllMarques() {
        return Response.ok(marqueService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getMarqueById(@PathParam("id") Integer id) {
        Marque marque = marqueService.findById(id);
        if (marque != null) {
            return Response.ok(marque).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addMarque(Marque marque) {
        marqueService.saveMarque(marque);
        return Response.status(Response.Status.CREATED).entity(marque).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateMarque(@PathParam("id") Integer id, Marque updatedMarque) {
        Marque existingMarque = marqueService.findById(id);
        if (existingMarque != null) {
            updatedMarque.setId(existingMarque.getId());
            marqueService.updateMarque(updatedMarque);
            return Response.ok(updatedMarque).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMarque(@PathParam("id") Integer id) {
        Marque marque = marqueService.findById(id);
        if (marque != null) {
            marqueService.deleteMarque(marque);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
