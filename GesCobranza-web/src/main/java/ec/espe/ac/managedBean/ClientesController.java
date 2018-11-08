package ec.espe.ac.managedBean;

import ec.edu.espe.ac.model.Agente;
import ec.edu.espe.ac.model.Cartera;
import ec.edu.espe.ac.model.Permora;
import ec.edu.espe.ac.session.AgenteFacadeLocal;
import ec.edu.espe.ac.session.CarteraFacadeLocal;
import ec.edu.espe.ac.session.PermoraFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author jhona
 */
@Named
@SessionScoped
public class ClientesController implements Serializable {

    @EJB
    private CarteraFacadeLocal EJBCartera;
    private List<Cartera> items = null;
    private Cartera selected;
    

    public ClientesController() {

    }

    public List<Cartera> getItems() {
        Agente ar = (Agente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agente");
        
        System.out.println("Estoy llenando los clientes para" + ar.getNombre() + " " + ar.getCodigoagente());
        if (items == null) {
        items =EJBCartera.CarteraFiltro(ar);
        }
          /*if (items == null) {
            for(int i=0; i<getFacade().count();i++)
              items.add(getFacade().find(ar));
            
        }*/
        return items;
    }

    public void setItems(List<Cartera> items) {
        this.items = items;
    }

    public CarteraFacadeLocal getEJBCartera() {
        return EJBCartera;
    }

    public void setEJBCartera(CarteraFacadeLocal EJBCartera) {
        this.EJBCartera = EJBCartera;
    }

    private CarteraFacadeLocal getFacade() {
        return EJBCartera;
    }

    public Cartera getSelected() {
        System.out.println("Este es el seleccionado? "+ selected.getCodigopermora().getNombrecliente());
        return selected;
    }

    public void setSelected(Cartera selected) {
        this.selected = selected;
    }

}
