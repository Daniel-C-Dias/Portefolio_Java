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
