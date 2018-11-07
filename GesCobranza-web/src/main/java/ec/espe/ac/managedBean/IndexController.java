package ec.espe.ac.managedBean;

import ec.edu.espe.ac.model.Agente;
import ec.edu.espe.ac.session.AgenteFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author jhona
 */
@Named
@ViewScoped
public class IndexController implements Serializable {

    @EJB
    private AgenteFacadeLocal EJBAgente;
    private Agente agente;
    
    @PostConstruct
    public void init() {
        agente = new Agente();
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public String iniciarSesion() {
        String redireccion = "";
        Agente us;
        try {
            System.out.println("Este agente va -> " + agente.getNombre());
            us = EJBAgente.iniciarSesion(agente, agente.getNombre());
            if (us != null) {
                // redireccion = "/Vista/Inicio?faces-redirect=true";
                redireccion = "/Vista/Inicio?faces-redirect=true";

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agente", us);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
                System.out.println("Fallamos prro :( ");
            }

        } catch (Exception e) {
            System.out.println("Error: " + agente.getClave());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "ERROR!"));
        }
        return redireccion;
    }
    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
