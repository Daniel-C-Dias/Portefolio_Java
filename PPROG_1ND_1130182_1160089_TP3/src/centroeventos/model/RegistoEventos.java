
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;
import Utilitarios.*;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoEventos {
    
    private static final RegistoEventos registoEventos = new RegistoEventos();
    private static final List<Evento> listaEventos = new ArrayList();
    private List<Evento> listaEventoOrganizador;
    
    private RegistoEventos(){
        
    }
    
    public static RegistoEventos getRegistoEventos( ) {
      return registoEventos;
   }
    
  

    public static List<Evento> getListaEventos() {
        return listaEventos;
    }
    
    
    private boolean addEvento(Evento e) {
        listaEventos.add(e);
        return true;
    }

    // validar também que a data é inferior à data inicio do evento!! 
    public List<Evento> getlistaEventosDeFae(Utilizador fae){
        List<Evento> listaEventosFae = new ArrayList();
        for (Evento e : listaEventos ){
            List<FAE> listaFae= e.getListaFaeEvento();
            for (FAE f : listaFae){
                if (f.getuFae().equals(fae)){
                    listaEventosFae.add(e);
                }
            }
        }
        return listaEventosFae;
    }
    
    
    public List<Evento> getlistaEventosDeOrganizador(Utilizador organizador){
        List<Evento> listaEventosOrganizador = new ArrayList();
        for (Evento e : listaEventos ){
            List<Organizador> listaOrganizador= e.getListaOrganizadoresEvento();
            for (Organizador o : listaOrganizador){
                if (o.getuOrganizador().equals(organizador)){
                    listaEventosOrganizador.add(e);
                }
            }
        }
        return listaEventosOrganizador;
    }
    
    public Evento novaExposicao()
    {
        return new Exposicao();
    }
    
    public Evento novoCongresso()
    {
        return new Congresso();
    }

    public boolean registaEvento(Evento e)
    {
        if( validaEvento(e) )
            return addEvento(e);
        else
            return false;
    }

    
    public boolean validaEvento(Evento e)
    {
        return e.valida();
    }
    
    public Evento getEvento(int eventoID){
        
        Evento eventoPretendido = null;
        
        for (Evento e : listaEventos) {
            if(e.getIdEvento() == eventoID) {
                eventoPretendido = e;
            }
        }
        
        return eventoPretendido;
    }
    
     public List<Evento> getEventosSubmissaoPronta() {
        
         List <Evento> eventosActivos = new ArrayList();
         
         for (Evento e : listaEventos ){
             if(Data.dataAtual().isMaior(e.getDataLimiteSubCandidaturas()) && Data.dataAtual().isMaior(e.getDataInicio())) {
                 continue;
             }
             else {
                 eventosActivos.add(e);
             }
         }
         
         return eventosActivos;
         
    }
     
      public Evento get(int index) {
        return getRegistoEventos().get(index);
    }
    
     public boolean containsEvento(Evento e) {
        return getRegistoEventos().containsEvento(e);
    }

   
     
     
}
