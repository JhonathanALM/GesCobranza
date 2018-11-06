package ec.espe.ac.managedBean;

import ec.edu.espe.ac.model.Cartera;
import ec.edu.espe.ac.model.CarteraFacadeLocal;
import ec.edu.espe.ac.model.Usuario;
import ec.edu.espe.ac.model.UsuarioFacadeLocal;
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
    private UsuarioFacadeLocal EJBUsuario;
    private Usuario usuario;
    
    @EJB
    private CarteraFacadeLocal EJBCartera;
    private Cartera cartera;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String iniciarSesion() {
        String redireccion = "";
        Usuario us;
        try {
            System.out.println("Este usuario va -> " + usuario.getNombre());
            us = EJBUsuario.iniciarSesion(usuario, usuario.getNombre());
            if (us != null) {
                // redireccion = "/Vista/Inicio?faces-redirect=true";
                redireccion = "/Vista/Inicio?faces-redirect=true";

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
                System.out.println("Fallamos prro :( ");
            }

        } catch (Exception e) {
            System.out.println("Error: " + usuario.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "ERROR!"));
        }
        return redireccion;
    }
    public String nan(){
        EJBCartera.create2(cartera);
        return " ";
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}