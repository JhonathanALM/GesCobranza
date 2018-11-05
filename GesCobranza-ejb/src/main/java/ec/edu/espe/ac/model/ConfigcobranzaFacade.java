package ec.edu.espe.ac.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
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
public class ConfigcobranzaFacade extends AbstractFacade<Configcobranza> implements ConfigcobranzaFacadeLocal {

    @EJB
    private CarteraFacadeLocal carteraFacade;

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    @PersistenceContext(unitName = "ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfigcobranzaFacade() {
        super(Configcobranza.class);
    }

    public int numeroConfigPorUser(Usuario id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
        EntityManager em1 = factory.createEntityManager();
        //pkg_jpa.Autor c1=new pkg_jpa.Autor();
        Query query = em1.createNamedQuery("Configcobranza.findByUserID").setParameter("userid", id);
        List<Configcobranza> list;
        int numRes;
        try {
            list = query.getResultList();
            numRes = list.size();
        } catch (Exception ex) {
            numRes = 0;
        }
        em1.close();
        factory.close();
        return numRes;
    }

    public int numeroConfigPorCartera(Cartera carteraId) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
        EntityManager em1 = factory.createEntityManager();
        //pkg_jpa.Autor c1=new pkg_jpa.Autor();
        Query query = em1.createNamedQuery("Configcobranza.findByCarteraID").setParameter("codigocartera", carteraId);
        List<Configcobranza> list;
        int numRes;
        try {
            list = query.getResultList();
            numRes = list.size();
        } catch (Exception ex) {
            numRes = 0;
        }
        em1.close();
        factory.close();
        return numRes;
    }

    @Override
    public int insertarConfigDia() {
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
        //EntityManager em1 = factory.createEntityManager();

        List<Usuario> usuariosTodos = usuarioFacade.listaUsuarioTodos();

        List<Cartera> carteraTodos = carteraFacade.listaCarteraTodos();

        Configcobranza c1 = new Configcobranza();

        int res=0;
        int usersNov = 0;
        int usersMed = 0;
        int usersExp = 0;


        try {

            //em1.getTransaction().begin();


            if (usuariosTodos != null) {
                for (Usuario opcion : usuariosTodos) {
                    if (opcion.getTipo().equals("novato")) {
                        usersNov++;
                    }
                    if (opcion.getTipo().equals("medio")) {
                        usersMed++;
                    }
                    if (opcion.getTipo().equals("experto")) {
                        usersExp++;
                    }
                }
            }

            List<Cartera> carNov = new ArrayList<Cartera>();
            List<Cartera> carMed = new ArrayList<Cartera>();
            List<Cartera> carExp = new ArrayList<Cartera>();
            if (carteraTodos != null) {


                for (ec.edu.espe.ac.model.Cartera opcion : carteraTodos) {
                    if (opcion.getNombreproducto().equals("CC") || opcion.getNombreproducto().equals("vehicular")) {
                        if (opcion.getMonto().intValue() < 20000 && opcion.getDiasmora().intValue() < 90) {
                            carNov.add(opcion);
                        }
                        if (opcion.getMonto().intValue() < 20000 && opcion.getDiasmora().intValue() >= 90) {
                            carMed.add(opcion);
                        }
                        if (opcion.getMonto().intValue() >= 20000 && opcion.getDiasmora().intValue() < 90) {
                            carMed.add(opcion);
                        }
                        if (opcion.getMonto().intValue() >= 20000 && opcion.getDiasmora().intValue() >= 90) {
                            carExp.add(opcion);
                        }
                    }
                }
            }

            if (carteraTodos != null && usuariosTodos != null) {
                for (Usuario opcionUser : usuariosTodos) {
                    if (opcionUser.getTipo().equals("novato")) {
                        for (ec.edu.espe.ac.model.Cartera opcion : carNov) {
                            if (numeroConfigPorUser(opcionUser) <= ((int) (carteraTodos.size() / usersNov))) {
                                if (numeroConfigPorCartera(opcion) == 0) {
                                    c1.setId(opcionUser);
                                    c1.setCodigocartera(opcion);
                                    c1.setAccion("SMS");
                                    c1.setCostollamada(BigInteger.valueOf(1l));
                                    c1.setEstado("Pendiente");
                                    em.persist(c1);

                                }
                            }
                        }
                    }
                    if (opcionUser.getTipo().equals("medio")) {
                        for (ec.edu.espe.ac.model.Cartera opcion : carNov) {
                            if (numeroConfigPorUser(opcionUser) <= ((int) (carteraTodos.size() / usersNov))) {
                                if (numeroConfigPorCartera(opcion) == 0) {
                                    c1.setId(opcionUser);
                                    c1.setCodigocartera(opcion);
                                    c1.setAccion("Correo");
                                    c1.setCostollamada(BigInteger.valueOf(3l));
                                    c1.setEstado("Pendiente");
                                    em.persist(c1);

                                }
                            }
                        }
                    }
                    if (opcionUser.getTipo().equals("experto")) {
                        for (ec.edu.espe.ac.model.Cartera opcion : carNov) {
                            if (numeroConfigPorUser(opcionUser) <= ((int) (carteraTodos.size() / usersNov))) {
                                if (numeroConfigPorCartera(opcion) == 0) {
                                    c1.setId(opcionUser);
                                    c1.setCodigocartera(opcion);
                                    c1.setAccion("Llamada");
                                    c1.setCostollamada(BigInteger.valueOf(5l));
                                    c1.setEstado("Pendiente");
                                    em.persist(c1);
                                }
                            }
                        }
                    }
                }
            }

            //em1.getTransaction().commit();
            //ssss
            

            res=1;
        } catch (Exception ex) {
            res=0;
            
        }
        //em1.close();
        //factory.close();
        return res;
    }

}
