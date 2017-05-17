/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroeventos.controller;

import centroeventos.model.CentroEventos;
import centroeventos.model.Utilizador;
import java.util.List;

/**
 *
 * @author gonca
 */
public class LoginController {
    
     private final CentroEventos centroEventos;
     private Utilizador userContexto;

    public LoginController(){
        this.centroEventos= CentroEventos.getCentroEventos();
    }
    
      /**
     * @return the userContext
     */
    public Utilizador getUserContexto() {
        return userContexto;
    }
    
    public boolean fazerLogin(String email, String password){
       
       if (validarLogin(email, password)){
           userContexto=setUserContexto(email);
           return true;
       }
       return false;
    }
    
    public String getUserName(){
        return userContexto.getUserName();
    }
    
    private boolean validarLogin(String email, String password){
       List<Utilizador> list = centroEventos.getRegistoUtilizadores().getListaUtilizadores();
       for (Utilizador u : list){
           if (u.validarAutenticacao(email, password)){
               return true;
           }
    }
       return false;
    }   

  
    private Utilizador setUserContexto(String email){
        return centroEventos.getRegistoUtilizadores().getUtilizadorPorEmail(email);
    }
    
}
