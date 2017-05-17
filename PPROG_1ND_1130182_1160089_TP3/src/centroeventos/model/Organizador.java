
package centroeventos.model;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class Organizador {
    
 private Utilizador uOrganizador;
  
  
    public Organizador()
    {
    }
    
    
     /**
     * @return the uOrganizador
     */
    public Utilizador getuOrganizador() {
        return uOrganizador;
    }
    
    public void setuOrganizador(Utilizador u)
    {
        this.uOrganizador = u;
    }
   
 
    public boolean valida()
    {
        // Introduzir as validações aqui
        return true;
    }
 
   
 @Override
    public String toString()
    {
        return this.getuOrganizador().toString();
    }

  
}

    

