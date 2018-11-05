package ec.edu.espe.ac.model;

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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(name = "ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU")
    
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    @Override
    public Usuario iniciarSesion(Usuario us, String usu) {
        Usuario usuario = null;
        String consulta;
        try {
            consulta = "FROM Usuario u WHERE u.nombre =?1";
            Query query = em.createQuery(consulta);
            System.out.println(usu + " ---- ");
            query.setParameter(1, usu);
            List<Usuario> lista = query.getResultList();

            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }

        } catch (Exception e) {
            System.out.println("ERROR!!!" + e);
        } finally {
            //
        }
        return usuario;
    }

    public List<Usuario> listaUsuarioTodos()
     {  
        //EntityManagerFactory factory=Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
        //EntityManager em1=factory.createEntityManager();        
        //pkg_jpa.Autor c1=new pkg_jpa.Autor();
        Query query = em.createNamedQuery("Usuario.findAll");
        List<Usuario> list;
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
