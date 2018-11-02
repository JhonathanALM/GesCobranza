package ec.edu.espe.ac.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author jhona
 */
@Stateless
public class ConfigcobranzaFacade extends AbstractFacade<Configcobranza> implements ConfigcobranzaFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfigcobranzaFacade() {
        super(Configcobranza.class);
    }

}
