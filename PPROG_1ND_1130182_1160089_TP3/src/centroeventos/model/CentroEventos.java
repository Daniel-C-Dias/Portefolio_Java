
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;
import centroeventos.model.RegistoEventos;
import centroeventos.model.Evento;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class CentroEventos {
    
    private  List <AlgoritmoAtribuicao> listaAlgoritmos = new ArrayList();
    private static  RegistoEventos registoEventos; //isto não é static? Mas sempre de eventos é static?
    private  RegistoUtilizadores registoUtilizadores;
    private static CentroEventos centroEventos = new CentroEventos();
    
    private CentroEventos(){
        
    }
    
    public static CentroEventos getCentroEventos( ) {
      return centroEventos;
   }

    public static RegistoEventos getRegistoEventos() {
        return registoEventos;
    }
    
   
    public RegistoUtilizadores getRegistoUtilizadores(){
       return registoUtilizadores;
    }
}
