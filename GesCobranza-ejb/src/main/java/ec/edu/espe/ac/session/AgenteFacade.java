package ec.edu.espe.ac.session;

import ec.edu.espe.ac.model.Agente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author jhona
 */
@Stateless
public class AgenteFacade extends AbstractFacade<Agente> implements AgenteFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgenteFacade() {
        super(Agente.class);
    }
    @Override
    public Agente iniciarSesion(Agente us, String usu) {
        Agente agente = null;
        String consulta;
        try {
            consulta = "FROM Agente u WHERE u.nombre =?1";
            Query query = em.createQuery(consulta);
            System.out.println(usu + " ---- ");
            query.setParameter(1, usu);
            List<Agente> lista = query.getResultList();

            if (!lista.isEmpty()) {
                agente = lista.get(0);
            }

        } catch (Exception e) {
            System.out.println("ERROR!!!" + e);
        } finally {
            //
        }
        return agente;
    }
    public List<Agente> listaAgenteTodos()
     {  
        //EntityManagerFactory factory=Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
        //EntityManager em1=factory.createEntityManager();        
        //pkg_jpa.Autor c1=new pkg_jpa.Autor();
        Query query = em.createNamedQuery("Agente.findAll");
        List<Agente> list;
        try
        {
            list = query.getResultList();
        }
        catch (Exception ex)
        {   
            list=null;
        } 
        //em.close();
        //factory.close();
        return list;
     }


}
