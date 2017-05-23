
package centroeventos.model;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class Participante {
    
     private Utilizador uParticipante;
     private String nome;
     
  
    public Participante()
    {
    }

    public Participante(Utilizador uParticipante, String nome) {
        this.uParticipante = uParticipante;
        this.nome=nome;
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
