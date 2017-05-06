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
public class FAE {
    
    Utilizador uFae;
    
    public FAE()
    {
      
    }
    
    public FAE(Utilizador u)
    {
      this.uFae = u;
    }
    
    public boolean valida()
    {
        // Introduzir as validações aqui
        return true;
    }
    
    @Override
    public String toString()
    {
        return this.uFae != null ? this.uFae.toString() : null;
    }
    
}
