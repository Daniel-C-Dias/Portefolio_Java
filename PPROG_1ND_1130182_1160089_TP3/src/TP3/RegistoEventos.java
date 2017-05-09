
package TP3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoEventos {

    private final List<Evento> listaEventos;
    private List<Evento> listaEventoOrganizador;

    
    public RegistoEventos(){
        this.listaEventos= new ArrayList();
    }

    private boolean addEvento(Evento e) {
        listaEventos.add(e);
        return true;
    }

     
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
    
    public Evento novoEvento()
    {
        return new Evento();
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
}
