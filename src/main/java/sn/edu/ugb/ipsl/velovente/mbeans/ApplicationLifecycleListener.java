package sn.edu.ugb.ipsl.velovente.mbeans;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import sn.edu.ugb.ipsl.velovente.services.EmailSessionBean;

//@Startup
//@Singleton
public class ApplicationLifecycleListener {

    @EJB
    private EmailSessionBean emailSessionBean;

    @PostConstruct
    public void startup() {
        // Envoyer un e-mail au démarrage
        try {
            String to = "jeanstyle131@gmail.com";
            String subject = "Démarrage de l'application";
            String body = "L'application a été démarrée.";
            emailSessionBean.sendEmail(to, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void shutdown() {
        // Envoyer un e-mail à l'arrêt
        try {
            String to = "jeanstyle131@gmail.com";
            String subject = "Arrêt de l'application";
            String body = "L'application va être arrêtée.";
            emailSessionBean.sendEmail(to, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

