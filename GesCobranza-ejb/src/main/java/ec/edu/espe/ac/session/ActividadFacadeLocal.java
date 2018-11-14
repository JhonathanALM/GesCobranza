/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ac.session;

import ec.edu.espe.ac.model.Actividad;
import ec.edu.espe.ac.model.Cartera;
import ec.edu.espe.ac.model.ReporteBanco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jhona
 */
@Local
public interface ActividadFacadeLocal {

    void create(Actividad actividad);

    void edit(Actividad actividad);

    void remove(Actividad actividad);

    Actividad find(Object id);

    List<Actividad> findAll();

    List<Actividad> findRange(int[] range);

    int count();
    
    List<Actividad> ActividadFiltro(Cartera codigo);
    List<Object[]> reporteBanco();
    
}
