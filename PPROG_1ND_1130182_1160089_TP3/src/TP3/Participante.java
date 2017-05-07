/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3;

/**
 *
 * @author gonca
 */
public class Participante {
    
     private Utilizador uParticipante;
     
  
    public Participante()
    {
    }
  
    
    public void setUtilizador(Utilizador u)
    {
        this.uParticipante = u;
    }
   
 
    public boolean valida()
    {
        // Introduzir as validações aqui
        return true;
    }
 
   
 @Override
    public String toString()
    {
        return this.uParticipante.toString();
    }
}
