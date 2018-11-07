package ec.edu.espe.ac.session;

import ec.edu.espe.ac.model.Fechaproceso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author jhona
 */
@Stateless
public class FechaprocesoFacade extends AbstractFacade<Fechaproceso> implements FechaprocesoFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FechaprocesoFacade() {
        super(Fechaproceso.class);
    }

}
