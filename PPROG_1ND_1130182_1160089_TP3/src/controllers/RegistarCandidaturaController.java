
package controllers;

import TP3.Evento;
import TP3.CentroEventos;
import TP3.RegistoEventos;
import TP3.RegistoCandidaturas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistarCandidaturaController {
    
    private Evento e;
    private RegistoEventos er;
    private List<Evento> lsre;
    private RegistoCandidaturas al;

    public RegistarCandidaturaController() {
    }

    public RegistarCandidaturaController(Evento e, RegistoEventos er, List<Evento> lsre, RegistoCandidaturas al) {
        this.e = e;
        this.er = er;
        this.lsre = lsre;
        this.al = al;
    }
    
    public List<Evento>  getEventosActivos(){ 
        return CentroEventos.getRegistoEventos();
    }
    
    public void setContext(int eventoID){
        this.e = RegistoEventos.getEvento(eventoID);
    }

   
    
    
}
