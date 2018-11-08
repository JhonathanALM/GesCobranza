/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.ac.managedBean;

import ec.edu.espe.ac.model.Actividad;
import ec.edu.espe.ac.model.Agente;
import ec.edu.espe.ac.model.Cartera;
import ec.edu.espe.ac.session.ActividadFacadeLocal;
import ec.edu.espe.ac.session.AgenteFacadeLocal;
import ec.edu.espe.ac.session.CarteraFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author User
 */
@Named(value = "newJSFManagedBean")
@SessionScoped
public class NewJSFManagedBean implements Serializable {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public NewJSFManagedBean() {
    }
    
    @EJB
    private AgenteFacadeLocal EJBAgente;
    private Agente agente;
    private String actual;
    
    @EJB
    private ActividadFacadeLocal EJBActividad;
    private Actividad Actividad;
    
    @EJB
    private CarteraFacadeLocal EJBCartera;
    private List<Cartera> clientes; 
    private Cartera ca = new Cartera();
    
    
    
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

    public void iniciarSesion() {
        System.out.println("hola1");
        try {
            EJBActividad.distribuir();
        } catch (Exception e) {
        }
        System.out.println("holaaaaa");
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public String getActual() {
        Agente as = (Agente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agente");
        System.out.println("Bienvenido Agente>> : "+as.getNombre());
        return as.getNombre()+"       |";
    }

    public void setActual(String actual) {
        
        this.actual=actual;
    }
    

    public List<Cartera> getClientes() {
        Agente ar = (Agente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agente");
        System.out.println("Estoy llenando los clientes para"+ar.getNombre()+" "+ar.getCodigoagente());
        
        return EJBCartera.CarteraFiltro(ar.getCodigoagente()+"");
    }

    public void setClientes(List<Cartera> clientes) {
        this.clientes = clientes;
    }

    public Cartera getCa() {
        return ca;
    }

    public void setCa(Cartera ca) {
        this.ca = ca;
    }
    
}
