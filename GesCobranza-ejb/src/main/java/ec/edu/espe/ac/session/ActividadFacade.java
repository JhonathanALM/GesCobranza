package ec.edu.espe.ac.session;

import ec.edu.espe.ac.model.Actividad;
import ec.edu.espe.ac.model.Cartera;
import ec.edu.espe.ac.model.ReporteBanco;
import java.util.ArrayList;
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

    @Override
    public List<Object[]> reporteBanco(){
        //List<ReporteBanco> reporte = new ArrayList<ReporteBanco>();
        System.out.println("pre sql");
        String sql= "select sum(sq2.valor) as total, sq2.INSTFINANCIERA as institucion, count(sq2.codigopermora) as numeroCasos from (select sq1.valor,permo.INSTFINANCIERA, sq1.codigopermora from PERMORA permo,(select acti.VALOR, acti.FECHAATENCION, acti.FECHATENTATIVA, acti.DETALLE, acti.TIPO, acti.OTRO, cart.CODIGOCAR, cart.CODIGOPERMORA as codigopermora from ACTIVIDAD acti, CARTERA cart where acti.CODIGOCAR=cart.CODIGOCAR and acti.FECHAATENCION in (select fp.FECHA from FECHAPROCESO fp)) sq1 where sq1.codigopermora=permo.CODIGOPERMORA) sq2 GROUP BY sq2.instfinanciera";
        Query q = em.createNativeQuery(sql);
        System.out.println("post sql");
        //reporte = q.getResultList();
        System.out.println("post resultado");
        List<Object[]>aux=q.getResultList();
        for(Object[] opc:aux){
            System.out.println(opc[0]);
            System.out.println(opc[1]);
            System.out.println(opc[2]);
        }
        return aux;
        //return reporte;
    }

    @Override
    public List<Object[]> reporteUsuarioEtiqueta(){
        //List<ReporteBanco> reporte = new ArrayList<ReporteBanco>();
        System.out.println("pre sql");
        //String sql= "select acti.FECHAATENCION, acti.ETIQUETA ,count(acti.ETIQUETA), Sum(acti.VALOR) from ACTIVIDAD acti where acti.FECHAATENCION in (select fp.FECHA from FECHAPROCESO fp) Group by acti.ETIQUETA,acti.FECHAATENCION";
        String sql= "select acti.FECHAATENCION, acti.ETIQUETA ,count(acti.ETIQUETA), Sum(acti.VALOR) from ACTIVIDAD acti Group by acti.ETIQUETA,acti.FECHAATENCION";
        Query q = em.createNativeQuery(sql);
        System.out.println("post sql");
        //reporte = q.getResultList();
        System.out.println("post resultado");
        List<Object[]>aux=q.getResultList();
        for(Object[] opc:aux){
            System.out.println(opc[0]);
            System.out.println(opc[1]);
            System.out.println(opc[2]);
            System.out.println(opc[3]);
        }
        return aux;
        //return reporte;
    }

    @Override
    public List<Object[]> reporteUsuarioTipo(){
        //List<ReporteBanco> reporte = new ArrayList<ReporteBanco>();
        System.out.println("pre sql");
        String sql= "select acti.FECHAATENCION, acti.TIPO ,count(acti.ETIQUETA), Sum(acti.VALOR) from ACTIVIDAD acti where acti.FECHAATENCION in (select fp.FECHA from FECHAPROCESO fp) Group by acti.TIPO,acti.FECHAATENCION";
        Query q = em.createNativeQuery(sql);
        System.out.println("post sql");
        //reporte = q.getResultList();
        System.out.println("post resultado");
        List<Object[]>aux=q.getResultList();
        for(Object[] opc:aux){
            System.out.println(opc[0]);
            System.out.println(opc[1]);
            System.out.println(opc[2]);
            System.out.println(opc[3]);
        }
        return aux;
        //return reporte;
    }

    
}
