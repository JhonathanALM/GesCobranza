/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ac.model;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jhona
 */
@Local
public interface ConfigcobranzaFacadeLocal {

    void create(Configcobranza configcobranza);

    void edit(Configcobranza configcobranza);

    void remove(Configcobranza configcobranza);

    Configcobranza find(Object id);

    List<Configcobranza> findAll();

    List<Configcobranza> findRange(int[] range);

    int count();
    
}
