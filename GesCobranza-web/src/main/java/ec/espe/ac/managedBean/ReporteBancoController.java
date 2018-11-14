/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.ac.managedBean;

import ec.edu.espe.ac.model.ReporteBanco;
import ec.edu.espe.ac.session.ActividadFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author User
 */
@Named(value = "reporteBancoController")
@SessionScoped
public class ReporteBancoController implements Serializable {

    @EJB
    ActividadFacadeLocal EJBActividad;
    /**
     * Creates a new instance of ReporteBancoController
     */
    public ReporteBancoController() {
        try {
            reporte = EJBActividad.reporteBanco();
        } catch (Exception e) {
            System.out.println("Error getReporte");
        }
    }
    
    
    private List<Object[]> reporte;

    public List<Object[]> getReporte() {
        try {
            reporte = EJBActividad.reporteBanco();
        } catch (Exception e) {
            System.out.println("Error getReporte");
        }
        return reporte;
    }

    public void setReporte(List<Object[]> reporte) {
        this.reporte = reporte;
    }
    
    
    
    
}
