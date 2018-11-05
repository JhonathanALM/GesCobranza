package ec.edu.espe.ac.model;

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
public class CarteraFacade extends AbstractFacade<Cartera> implements CarteraFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarteraFacade() {
        super(Cartera.class);
    }
    
    public List<Cartera> listaCarteraTodos()
     {  
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
        EntityManager em1=factory.createEntityManager();        
        //pkg_jpa.Autor c1=new pkg_jpa.Autor();
        Query query = em1.createNamedQuery("Cartera.findAll");
        List<Cartera> list;
        try
        {
            list = query.getResultList();
        }
        catch (Exception ex)
        {   
            list=null;
        } 
        em1.close();
        factory.close();
        return list;
     }
    
    public List<Cartera> listaCarteraPorFecha(Date fechaCarga)
     {  
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
        EntityManager em1=factory.createEntityManager();        
        //pkg_jpa.Autor c1=new pkg_jpa.Autor();
        Query query = em1.createNamedQuery("Cartera.findByFechacarga").setParameter("fechacarga", fechaCarga);
        List<Cartera> list;
        try
        {
            list = query.getResultList();
        }
        catch (Exception ex)
        {   
            list=null;
        } 
        em1.close();
        factory.close();
        return list;
     }
    
    

}
