package ec.espe.ac.managedBean;
import ec.edu.espe.ac.model.Actividad;
import ec.edu.espe.ac.model.Agente;
import ec.edu.espe.ac.model.Cartera;
import ec.edu.espe.ac.session.ActividadFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author jhona
 */
@Named(value = "actividadController")
@ViewScoped
public class ActividadController implements Serializable{
@EJB
    private ActividadFacadeLocal EJBActividad;
    private Actividad ad;
    private List<Actividad> items2 = null;

    public ActividadController() {
    }
    
    public List<Actividad> getItems2() {
        Cartera ar = (Cartera) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cartera");
        System.out.println("Estoy las actividades de: " + ar);
        if (items2 == null) {
            items2 = EJBActividad.ActividadFiltro(ar);
        }
        return items2;
    }

    public void setItems2(List<Actividad> items2) {
        this.items2 = items2;
    }
    
}
