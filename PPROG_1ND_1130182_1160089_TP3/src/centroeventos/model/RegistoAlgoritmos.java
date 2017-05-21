
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoAlgoritmos {
    private static final RegistoAlgoritmos registoAlgoritmos = new RegistoAlgoritmos();
    private static final List<AlgoritmoAtribuicao> listaAlgoritmos = new ArrayList();
    
     private RegistoAlgoritmos(){
        
    }
    
    public static RegistoAlgoritmos getRegistoAlgoritmos( ) {
      return registoAlgoritmos;
   }

    public static List<AlgoritmoAtribuicao> getListaAlgoritmos() {
        return listaAlgoritmos;
    }
    
    private boolean addAlgoritmo(AlgoritmoAtribuicao a) {
        listaAlgoritmos.add(a);
        return true;
    }
    
    public boolean registaAlgoritmo(AlgoritmoAtribuicao a)
    {
        if( validaAlgoritmo(a) )
            return addAlgoritmo(a);
        else
            return false;
    }

    
    public boolean validaAlgoritmo(AlgoritmoAtribuicao a)
    {
        return a.valida();
    }
    
    
    
     public Evento get(int index) {
        return getRegistoAlgoritmos().get(index);
    }
    
     public boolean containsAlgoritmo(AlgoritmoAtribuicao a) {
        return getRegistoAlgoritmos().containsAlgoritmo(a);
    }
}
