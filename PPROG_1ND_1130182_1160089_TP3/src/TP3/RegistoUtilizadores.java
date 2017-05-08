
package TP3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoUtilizadores {
    
    
    List<Evento> listaUtilizadores = new ArrayList();

    public boolean add(Evento e) {
        listaUtilizadores.add(e);
        return true;
    }

    public Evento get(int index) {
        return listaUtilizadores.get(index);
    }
    
    
}
