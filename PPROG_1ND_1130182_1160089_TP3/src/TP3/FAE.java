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
    
    private Utilizador uFae;
    
    public FAE(){
      
    }
    
    public FAE(Utilizador u)
    {
      this.uFae = u;
    }
    
        /**
     * @return the uFae
     */
    public Utilizador getuFae() {
        return uFae;
    }

    /**
     * @param uFae the uFae to set
     */
    public void setuFae(Utilizador uFae) {
        this.uFae = uFae;
    }
    
    public boolean valida()
    {
        // Introduzir as validações aqui
        return true;
    }
    
    @Override
    public String toString()
    {
        return this.getuFae().toString();
    }

    public boolean equals(FAE obj) {
        return (this.uFae == obj.uFae);
    }
    
}

