
package TP3;

import java.util.ArrayList;
import java.util.List;
import TP3.RegistoEventos;
import TP3.Evento;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class CentroEventos {
    
    private  List <AlgoritmoAtribuicao> listaAlgoritmos = new ArrayList();
    private  RegistoEventos registoEventos;
    private  RegistoUtilizadores registoUtilizadores;
    private static CentroEventos centroEventos = new CentroEventos();
    
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
}
