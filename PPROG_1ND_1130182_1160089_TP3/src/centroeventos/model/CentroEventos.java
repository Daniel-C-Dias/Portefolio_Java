
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
    private  RegistoUtilizadores registoUtilizadores= RegistoUtilizadores.getRegistoUtilizadores();
    private static CentroEventos centroEventos = new CentroEventos();
    private  RegistoEventos registoEventos = RegistoEventos.getRegistoEventos();
    
    private CentroEventos(){
        
    }
    
    public static CentroEventos getCentroEventos( ) {
        return centroEventos;
   }

    public RegistoEventos getRegistoEventos() {
        return registoEventos;
    }

   
    public RegistoUtilizadores getRegistoUtilizadores(){
       return registoUtilizadores;
    }

    public void setRegistoEventos(RegistoEventos registoEventos) {
        this.registoEventos = (RegistoEventos) RegistoEventos.getListaEventos();
    }

    
}
