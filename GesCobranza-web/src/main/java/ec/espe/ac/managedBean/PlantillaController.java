package ec.espe.ac.managedBean;

import ec.edu.espe.ac.model.Agente;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author jhona
 */
@Named
@ViewScoped
public class PlantillaController implements Serializable{

    public void verificarSesion (){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Agente us = (Agente) context.getExternalContext().getSessionMap().get("agente");
            if (us == null) {
                context.getExternalContext().redirect("./../permisos.xhtml");

            }
        } catch (Exception e) {
            //implementaciones para guardar regitrso de un error
        }

    }

}
