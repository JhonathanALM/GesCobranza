/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ac.session;

import ec.edu.espe.ac.model.Fechaproceso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jhona
 */
@Local
public interface FechaprocesoFacadeLocal {

    void create(Fechaproceso fechaproceso);

    void edit(Fechaproceso fechaproceso);

    void remove(Fechaproceso fechaproceso);

    Fechaproceso find(Object id);

    List<Fechaproceso> findAll();

    List<Fechaproceso> findRange(int[] range);

    int count();
    
}
