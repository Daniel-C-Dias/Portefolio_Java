
package TP3;

/**
 *
 * @author Daniel Dias & José Gonçalves
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
     * @Construtor de Cópia
     */
    public FAE(FAE outroFAE){
        this.uFae = outroFAE.uFae;
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

