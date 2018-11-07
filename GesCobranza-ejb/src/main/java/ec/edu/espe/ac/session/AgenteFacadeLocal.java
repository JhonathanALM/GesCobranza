/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ac.session;

import ec.edu.espe.ac.model.Agente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jhona
 */
@Local
public interface AgenteFacadeLocal {

    void create(Agente agente);

    void edit(Agente agente);

    void remove(Agente agente);

    Agente find(Object id);

    List<Agente> findAll();

    List<Agente> findRange(int[] range);
     
    Agente iniciarSesion(Agente us, String usu);
    
    int count();
    
}
