package ec.espe.ac.managedBean;
import ec.edu.espe.ac.model.Agente;
import ec.edu.espe.ac.model.Cartera;
import ec.edu.espe.ac.model.Permora;
import ec.edu.espe.ac.session.AgenteFacadeLocal;
import ec.edu.espe.ac.session.CarteraFacadeLocal;
import ec.edu.espe.ac.session.PermoraFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
/**
 *
 * @author jhona
 */
@Named
@ViewScoped
public class ClientesController implements Serializable{
    @EJB
    private PermoraFacadeLocal EJBPermora;
    private Permora ct = new Permora();

    @EJB
    private AgenteFacadeLocal EJBAgente;
    private Agente ag = new Agente();

    @EJB
    private CarteraFacadeLocal EJBCartera;
    private Cartera ca = new Cartera();
            
    public ClientesController() {       
      
    }
    
}
