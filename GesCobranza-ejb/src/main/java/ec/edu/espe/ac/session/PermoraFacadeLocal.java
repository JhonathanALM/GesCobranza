/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ac.session;
import ec.edu.espe.ac.model.Permora;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jhona
 */
@Local
public interface PermoraFacadeLocal {

    void create(Permora permora);

    void edit(Permora permora);

    void remove(Permora permora);

    Permora find(Object id);

    List<Permora> findAll();

    List<Permora> findRange(int[] range);

    int count();
    
    List<Permora> listaPermoraTodos();
    List<Permora> listaPermoraPorFecha();
    
}
