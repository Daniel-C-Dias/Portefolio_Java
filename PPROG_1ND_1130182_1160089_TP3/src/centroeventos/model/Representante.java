
package centroeventos.model;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class Representante {
    
    private Utilizador uRepresentante;
  
  
    public Representante()
    {
    }

    public Representante(Utilizador uRepresentante) {
        this.uRepresentante = uRepresentante;
    }
    

  
  
    public void setUtilizador(Utilizador u)
    {
        this.uRepresentante = u;
    }
   
 
    public boolean valida()
    {
        // Introduzir as validações aqui
        return true;
    }
 
   
 @Override
    public String toString()
    {
        return this.uRepresentante.toString();
    }
}
