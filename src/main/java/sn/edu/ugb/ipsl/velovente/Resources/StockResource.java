package sn.edu.ugb.ipsl.velovente.Resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import sn.edu.ugb.ipsl.velovente.services.StockService;
import sn.edu.ugb.ipsl.velovente.model.Stock;

@Path("/stocks")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class StockResource {

    @EJB
    private StockService stockService;

    @GET
    public Response getAllStocks() {
        return Response.ok(stockService.findAll()).build();
    }

    @GET
    @Path("/{idmagasin}/{idproduit}")
    public Response getStockById(@PathParam("idmagasin") Integer idmagasin,@PathParam("idproduit") Integer idproduit) {
        Stock stock = stockService.findById(idmagasin,idproduit);
        if (stock != null) {
            return Response.ok(stock).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addStock(Stock stock) {
        stockService.saveStock(stock);
        return Response.status(Response.Status.CREATED).entity(stock).build();
    }

    @PUT
    @Path("/{idmagasin}/{idproduit}")
    public Response updateStock(@PathParam("idmagasin") Integer idmagasin,@PathParam("idproduit") Integer idproduit , Stock updatedStock) {
        Stock existingStock = stockService.findById(idmagasin,idproduit);
        if (existingStock != null) {
            updatedStock.setStockPK(existingStock.getStockPK());
            stockService.updateStock(updatedStock);
            return Response.ok(updatedStock).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{idmagasin}/{idproduit}")
    public Response deleteStock(@PathParam("idmagasin") Integer idmagasin,@PathParam("idproduit") Integer idproduit ) {
        Stock stock = stockService.findById(idmagasin,idproduit);
        if (stock != null) {
            stockService.deleteStock(stock);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
