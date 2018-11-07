package ec.edu.espe.ac.session;

import ec.edu.espe.ac.model.Permora;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author jhona
 */
@Stateless
public class PermoraFacade extends AbstractFacade<Permora> implements PermoraFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermoraFacade() {
        super(Permora.class);
    }

}
