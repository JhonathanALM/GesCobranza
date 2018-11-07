/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ac.session;

import ec.edu.espe.ac.model.Cartera;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jhona
 */
@Local
public interface CarteraFacadeLocal {

    void create(Cartera cartera);

    void edit(Cartera cartera);

    void remove(Cartera cartera);

    Cartera find(Object id);

    List<Cartera> findAll();

    List<Cartera> findRange(int[] range);

    int count();
    
}
