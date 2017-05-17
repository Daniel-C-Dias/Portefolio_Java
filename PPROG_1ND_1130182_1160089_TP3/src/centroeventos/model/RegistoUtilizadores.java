
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoUtilizadores {
    
    
   private List<Evento> listaUtilizadores;
   
   private static RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();
    
    private RegistoUtilizadores(){
        
    }
    
    public static RegistoUtilizadores getRegistoUtilizadores( ) {
      return registoUtilizadores;
   }
    
   
    public boolean add(Evento e) {
        listaUtilizadores.add(e);
        return true;
    }

    public Evento get(int index) {
        return listaUtilizadores.get(index);
    }
    
    
}
