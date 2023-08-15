package sn.edu.ugb.ipsl.velovente.Resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import sn.edu.ugb.ipsl.velovente.services.ArticleCommandeService;
import sn.edu.ugb.ipsl.velovente.model.ArticleCommande;

@Path("/articlecommandes")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ArticleCommandeResource {

    @EJB
    private ArticleCommandeService articleCommandeService;

    @GET
    public Response getAllArticleCommandes() {
        return Response.ok(articleCommandeService.findAll()).build();
    }

    @GET
    @Path("/{numcommande}/{numligne}")
    public Response getArticleCommandeById(@PathParam("numcommande") Integer numcommande,@PathParam("numligne") Integer numligne) {
        ArticleCommande articleCommande = articleCommandeService.findById(numcommande,numligne);
        if (articleCommande != null) {
            return Response.ok(articleCommande).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addArticleCommande(ArticleCommande articleCommande) {
        articleCommandeService.saveArticleCommande(articleCommande);
        return Response.status(Response.Status.CREATED).entity(articleCommande).build();
    }

    @PUT
    @Path("/{numcommande}/{numligne}")
    public Response updateArticleCommande(@PathParam("numcommande") Integer numcommande,@PathParam("numligne") Integer numligne, ArticleCommande updatedArticleCommande) {
        ArticleCommande existingArticleCommande = articleCommandeService.findById(numcommande,numligne);
        if (existingArticleCommande != null) {
            updatedArticleCommande.setArticleCommandePK(existingArticleCommande.getArticleCommandePK());
            articleCommandeService.updateArticleCommande(updatedArticleCommande);
            return Response.ok(updatedArticleCommande).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{numcommande}/{numligne}")
    public Response deleteArticleCommande(@PathParam("numcommande") Integer numcommande,@PathParam("numligne") Integer numligne) {
        ArticleCommande articleCommande = articleCommandeService.findById(numcommande,numligne);
        if (articleCommande != null) {
            articleCommandeService.deleteArticleCommande(articleCommande);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
