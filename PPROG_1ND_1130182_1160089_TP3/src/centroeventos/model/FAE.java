
package centroeventos.model;

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

