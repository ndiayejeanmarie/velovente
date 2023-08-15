package sn.edu.ugb.ipsl.velovente;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title = "Vente Velo API",
                description = "Api pour la plateforme de vente de velo",
                contact = @Contact(
                        email = "ndiaye.jean-marie-fande@ugb.edu.sn",
                        name = "Jean Marie Fande NDIAYE",
                        url = "https://ugb.edu.sn"
                )
        ),
        servers = @Server(
                url = "http://localhost:8080/veloVente-1.0-SNAPSHOT/",
                description = "serveur de l'Api"
        )
)
@ApplicationPath("api")
public class ApiConfig extends Application {
}
