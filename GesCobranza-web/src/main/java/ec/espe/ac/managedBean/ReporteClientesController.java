/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.ac.managedBean;

import ec.edu.espe.ac.session.ActividadFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author User
 */
@Named(value = "reporteClientesController")
@Dependent
public class ReporteClientesController {

    
    @EJB
    ActividadFacadeLocal EJBActividad;
    
    /**
     * Creates a new instance of ReporteClientesController
     */
    public ReporteClientesController() {
    }
    
    private List<Object[]> reporteUsuarioTipo;
    private List<Object[]> reporteUsuarioEtiqueta;

    public List<Object[]> getReporteUsuarioTipo() {
        try {
            reporteUsuarioTipo = EJBActividad.reporteUsuarioTipo();
        } catch (Exception e) {
            System.out.println("Error getReporte");
        }
        
        return reporteUsuarioTipo;
    }

    public void setReporteUsuarioTipo(List<Object[]> reporteUsuarioTipo) {
        this.reporteUsuarioTipo = reporteUsuarioTipo;
    }

    public List<Object[]> getReporteUsuarioEtiqueta() {
        try {
            reporteUsuarioEtiqueta = EJBActividad.reporteUsuarioEtiqueta();
        } catch (Exception e) {
            System.out.println("Error getReporte");
        }
        return reporteUsuarioEtiqueta;
    }

    public void setReporteUsuarioEtiqueta(List<Object[]> reporteUsuarioEtiqueta) {
        this.reporteUsuarioEtiqueta = reporteUsuarioEtiqueta;
    }
    
    
    
}
