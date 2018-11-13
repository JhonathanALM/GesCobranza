package ec.edu.espe.ac.session;

import ec.edu.espe.ac.model.Actividad;
import ec.edu.espe.ac.model.Agente;
import ec.edu.espe.ac.model.Cartera;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author jhona
 */
@Stateless
public class ActividadFacade extends AbstractFacade<Actividad> implements ActividadFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadFacade() {
        super(Actividad.class);
    }
    @Override
    public List<Actividad> ActividadFiltro(Cartera codigo) {
        
        Query qry = this.em.createQuery("SELECT obj FROM Actividad obj WHERE obj.codigocar=?1");
        qry.setParameter(1, codigo);
        return qry.getResultList();        
    }
    

}
