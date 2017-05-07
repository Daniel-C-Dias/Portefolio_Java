/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gonca
 */
public class RegistoEventos {

    private List<Evento> listaEventos = new ArrayList();
    
    

    public boolean add(Evento e) {
        listaEventos.add(e);
        return true;
    }

    public Evento get(int index) {
        return listaEventos.get(index);
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
    
//    public Evento novoEvento()
//    {
//        return new Evento();
//    }
//
//    public boolean registaEvento(Evento e)
//    {
//        if( validaEvento(e) )
//            return addEvento(e);
//        else
//            return false;
//    }
//
//    private boolean addEvento(Evento e)
//    {
//        return listaEventos.add(e);
//    }
//    
//    public boolean validaEvento(Evento e)
//    {
//        return e.valida();
//    }
}
