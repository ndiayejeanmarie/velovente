package sn.edu.ugb.ipsl.velovente.Resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import sn.edu.ugb.ipsl.velovente.services.MagasinService;
import sn.edu.ugb.ipsl.velovente.model.Magasin;

@Path("/magasins")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class MagasinResource {

    @EJB
    private MagasinService magasinService;

    @GET
    public Response getAllMagasins() {
        return Response.ok(magasinService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getMagasinById(@PathParam("id") Integer id) {
        Magasin magasin = magasinService.findById(id);
        if (magasin != null) {
            return Response.ok(magasin).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addMagasin(Magasin magasin) {
        magasinService.saveMagasin(magasin);
        return Response.status(Response.Status.CREATED).entity(magasin).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateMagasin(@PathParam("id") Integer id, Magasin updatedMagasin) {
        Magasin existingMagasin = magasinService.findById(id);
        if (existingMagasin != null) {
            updatedMagasin.setId(existingMagasin.getId());
            magasinService.updateMagasin(updatedMagasin);
            return Response.ok(updatedMagasin).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMagasin(@PathParam("id") Integer id) {
        Magasin magasin = magasinService.findById(id);
        if (magasin != null) {
            magasinService.deleteMagasin(magasin);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
