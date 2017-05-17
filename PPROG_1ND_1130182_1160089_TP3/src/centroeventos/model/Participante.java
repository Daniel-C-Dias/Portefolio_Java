
package centroeventos.model;

/**
 *
 * @author Daniel Dias & José Gonçalves
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
