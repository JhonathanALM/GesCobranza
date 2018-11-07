package ec.edu.espe.ac.session;

import ec.edu.espe.ac.model.Permora;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    public List<Permora> listaPermoraTodos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
        EntityManager em1 = factory.createEntityManager();
        //pkg_jpa.Autor c1=new pkg_jpa.Autor();
        Query query = em1.createNamedQuery("Permora.findAll");
        List<Permora> list;
        try {
            list = query.getResultList();
        } catch (Exception ex) {
            list = null;
        }
        em1.close();
        factory.close();
        return list;
    }

    public List<Permora> listaPermoraPorFecha(Date fechaCarga) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
        EntityManager em1 = factory.createEntityManager();
        //pkg_jpa.Autor c1=new pkg_jpa.Autor();
        Query query = em1.createNamedQuery("Permora.findByFechacarga").setParameter("fechacarga", fechaCarga);
        List<Permora> list;
        try {
            list = query.getResultList();
        } catch (Exception ex) {
            list = null;
        }
        em1.close();
        factory.close();
        return list;
    }

}
