package ec.edu.espe.ac.session;

import ec.edu.espe.ac.model.Agente;
import ec.edu.espe.ac.model.Cartera;
import ec.edu.espe.ac.model.Permora;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
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
@LocalBean
public class CarteraFacade extends AbstractFacade<Cartera> implements CarteraFacadeLocal {

    @PersistenceContext(unitName = "ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU")
    private EntityManager em;

    @EJB
    private AgenteFacadeLocal agenteFacade;

    @EJB
    private PermoraFacadeLocal permoraFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarteraFacade() {
        super(Cartera.class);
    }

    @Override
    public List<Cartera> listaCarteraTodos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
        EntityManager em1 = factory.createEntityManager();
        //pkg_jpa.Autor c1=new pkg_jpa.Autor();
        Query query = em1.createNamedQuery("Cartera.findAll");
        List<Cartera> list;
        try {
            list = query.getResultList();
        } catch (Exception ex) {
            list = null;
        }
        em1.close();
        factory.close();
        return list;
    }

    @Override
    public List<Cartera> CarteraFiltro(Agente codigo) {
        /*EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
        EntityManager em1 = factory.createEntityManager();
        //pkg_jpa.Autor c1=new pkg_jpa.Autor();
        Query query = em1.createNativeQuery("SELECT codigoPerMora FROM CARTERA WHERE codigoAgente="+codigo);
            System.out.println(query+"");
        List<Cartera> list;
        try {
            list = query.getResultList();
        } catch (Exception ex) {
            list = null;
        }
        em1.close();
        factory.close();
        //List<Cartera> list;
        //list = em.createNamedQuery("Cartera.findByName").setParameter("name", codigo).getResultList();
         */
        Query qry = this.em.createQuery("SELECT obj FROM Cartera obj WHERE obj.codigoagente=?1");
        qry.setParameter(1, codigo);
        return qry.getResultList();
        //return list;
    }
    /*@Override
    public double CarteraFiltro2(Agente codigo) {

        Query qry = this.em.createQuery("SELECT SUM(B.montototal) FROM Cartera as A join Permora as B " +
                                        "WHERE A.codigopermora= B.codigopermora " +
                                        "AND A.codigoagente=?1");
        qry.setParameter(1, codigo);
        return qry.getResultList();
        //return list;
    }*/
    

    
    @Override
    public int insertarConfigDia() {
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("ec.edu.espe.ac_GesCobranza-ejb_ejb_1PU");
        //EntityManager em1 = factory.createEntityManager();
        System.out.println("entre a insertarConfigDia");
        List<Agente> agentesTodos = agenteFacade.listaAgenteTodos();
        List<Permora> carteraTodos = permoraFacade.listaPermoraTodos();
        Cartera c1 = new Cartera();

        List<Agente> usersNov = new ArrayList<Agente>();
        List<Agente> usersMed = new ArrayList<Agente>();
        List<Agente> usersExp = new ArrayList<Agente>();
        int res = 0;

        try {
            //em1.getTransaction().begin();
            if (agentesTodos != null) {
                for (Agente opcion : agentesTodos) {
                    if (opcion.getTipo().equals("novato")) {
                        usersNov.add(opcion);
                        System.out.println("Se añadadio a "+opcion.getNombre()+" como novato");
                    }
                    if (opcion.getTipo().equals("medio")) {
                        usersMed.add(opcion);
                        System.out.println("Se añadadio a "+opcion.getNombre()+" como medio");
                    }
                    if (opcion.getTipo().equals("experto")) {
                        usersExp.add(opcion);
                        System.out.println("Se añadadio a "+opcion.getNombre()+" como experto");
                    }
                }
            }
            List<Permora> carNov = new ArrayList<Permora>();
            List<Permora> carMed = new ArrayList<Permora>();
            List<Permora> carExp = new ArrayList<Permora>();

            if (carteraTodos != null) {
                for (Permora opcion : carteraTodos) {
                    if (opcion.getNombreproducto().equals("CC") || opcion.getNombreproducto().equals("vehicular")) {
                        if (opcion.getMonto().intValue() < 20000 && opcion.getDiasmora().intValue() < 90) {
                            carNov.add(opcion);
                            System.out.println("cc-vh");
                        }
                        if (opcion.getMonto().intValue() < 20000 && opcion.getDiasmora().intValue() >= 90) {
                            carMed.add(opcion);
                            System.out.println("cc-vh>90");
                            
                        }
                        if (opcion.getMonto().intValue() >= 20000 && opcion.getDiasmora().intValue() < 90) {
                            carMed.add(opcion);
                            System.out.println("cc-vh<90");
                        }
                        if (opcion.getMonto().intValue() >= 20000 && opcion.getDiasmora().intValue() >= 90) {
                            carExp.add(opcion);
                            System.out.println("cc-vh>90>200");
                        }
                    }
                    if (opcion.getNombreproducto().equals("hipotecario") || opcion.getNombreproducto().equals("comercial")) {
                        if (opcion.getMonto().intValue() < 30000 && opcion.getDiasmora().intValue() < 90) {
                            carNov.add(opcion);
                            System.out.println("hi-com1");
                        }
                        if (opcion.getMonto().intValue() < 30000 && opcion.getDiasmora().intValue() >= 90) {
                            carMed.add(opcion);
                            System.out.println("hi-com1");
                        }
                        if (opcion.getMonto().intValue() >= 30000 && opcion.getDiasmora().intValue() < 90) {
                            carMed.add(opcion);
                            System.out.println("hi-com1");
                        }
                        if (opcion.getMonto().intValue() >= 30000 && opcion.getDiasmora().intValue() >= 90) {
                            carExp.add(opcion);
                            System.out.println("hi-com1");
                        }
                    }
                }
            }
            if (carteraTodos != null && agentesTodos != null) {
                distribucion(usersNov, carNov);
                distribucion(usersMed, carMed);
                distribucion(usersExp, carExp);
                /*
                
                for (Agente opcionUser : agentesTodos) {
                    
                    if (opcionUser.getTipo().equals("novato")) {
                        for (Permora opcion : carNov) {
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
                
                }*/
            }
            //em1.getTransaction().commit();
            //ssss

            res = 1;
        } catch (Exception ex) {
            res = 0;

        }
        //em1.close();
        //factory.close();
        return res;
    }

    public int distribucion(List<Agente> listAgente, List<Permora> listPermora) {
        List<Permora> originalList = listPermora;
        int car = listPermora.size();
        int usu = listAgente.size();
        int partitionSize = 0;

        double aux = 0;
        int res = 0;

        if (usu != 0) {
            aux = (double) car / usu;
            res = (car % usu);
        }

        System.out.println(aux);
        if ((aux - Math.floor(aux)) < 0.5) {
            partitionSize = (int) Math.floor(aux);
        }
        if ((aux - Math.floor(aux)) >= 0.5) {
            partitionSize = (int) Math.ceil(aux);
        }

        List<List<String>> partitions = new ArrayList<List<String>>();
        int fin = 0;
        List<Permora> auxList = new ArrayList<Permora>();
        int agenteAct = 0;

        if ((aux - Math.floor(aux)) >= 0.5) {
            for (int i = 0; i < originalList.size(); i += partitionSize) {
                auxList = originalList.subList(i,
                        Math.min(i + partitionSize, originalList.size()));
                fin = Math.min(i + partitionSize, originalList.size());

                for (Permora perAct : auxList) {
                    insertaCartera(listAgente.get(agenteAct), perAct);
                }
                agenteAct++;
            }
        }
        if ((aux - Math.floor(aux)) < 0.5) {
            for (int i = 0; i < originalList.size(); i += partitionSize) {
                if (res > 0) {
                    auxList = originalList.subList(i,
                            (Math.min(i + partitionSize, originalList.size())) + 1);
                    System.out.println(res);
                    res--;
                    i++;
                    for (Permora perAct : auxList) {
                        insertaCartera(listAgente.get(agenteAct), perAct);
                    }
                    agenteAct++;
                } else {
                    auxList = originalList.subList(i,
                            Math.min(i + partitionSize, originalList.size()));
                    fin = Math.min(i + partitionSize, originalList.size());
                    for (Permora perAct : auxList) {
                        insertaCartera(listAgente.get(agenteAct), perAct);
                    }
                    agenteAct++;
                }
            }
        }

        System.out.println(partitions.toString());
        return 0;
    }

    public int insertaCartera(Agente agente, Permora permora) {
        Cartera c1 = new Cartera();
        int i=0;
        System.out.println("insertando en cartera..."+ agente.getNombre()+" -  "+permora.getNombrecliente());
        try {
            c1.setCodigocar(BigDecimal.valueOf(Long.valueOf(i)));
            c1.setCodigoagente(agente);
            c1.setCodigopermora(permora);
            c1.setFechaasig(new java.sql.Date(new java.util.Date().getTime()));
            c1.setEstadoasig(BigInteger.valueOf(1));
            try{
                em.persist(c1);
                //this.create(c1);
                System.out.println("Se persitio4?");
            }catch(Exception e){
                System.out.println("Un error al persistir");
            }
            //this.create(c1);
            return 1;
        } catch (Exception e) {
            System.out.println("ex:" + e);
            return 0;
        }
    }
}
