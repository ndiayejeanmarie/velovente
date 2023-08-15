package sn.edu.ugb.ipsl.velovente.Resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import sn.edu.ugb.ipsl.velovente.services.EmployeService;
import sn.edu.ugb.ipsl.velovente.model.Employe;

@Path("/employes")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class EmployeResource {

    @EJB
    private EmployeService employeService;

    @GET
    public Response getAllEmployes() {
        return Response.ok(employeService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getEmployeById(@PathParam("id") Integer id) {
        Employe employe = employeService.findById(id);
        if (employe != null) {
            return Response.ok(employe).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addEmploye(Employe employe) {
        employeService.saveEmploye(employe);
        return Response.status(Response.Status.CREATED).entity(employe).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateEmploye(@PathParam("id") Integer id, Employe updatedEmploye) {
        Employe existingEmploye = employeService.findById(id);
        if (existingEmploye != null) {
            updatedEmploye.setId(existingEmploye.getId());
            employeService.updateEmploye(updatedEmploye);
            return Response.ok(updatedEmploye).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmploye(@PathParam("id") Integer id) {
        Employe employe = employeService.findById(id);
        if (employe != null) {
            employeService.deleteEmploye(employe);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
