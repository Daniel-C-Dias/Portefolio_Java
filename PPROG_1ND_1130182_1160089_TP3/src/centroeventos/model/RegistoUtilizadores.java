
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoUtilizadores {
    
    
   private List<Utilizador> listaUtilizadores;
   
   private static RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();
    
    private RegistoUtilizadores(){
        
    }
    
    public static RegistoUtilizadores getRegistoUtilizadores( ) {
      return registoUtilizadores;
   }
    
    
   
    public boolean add(Utilizador u) {
        getListaUtilizadores().add(u);
        return true;
    }

    public Utilizador get(int index) {
        return getListaUtilizadores().get(index);
    }
    
     public boolean containsUtilizador(Utilizador u) {
        return getListaUtilizadores().contains(u);
    }

    /**
     * @return the listaUtilizadores
     */
    public List<Utilizador> getListaUtilizadores() {
        return listaUtilizadores;
    }

    /**
     * @param listaUtilizadores the listaUtilizadores to set
     */
    public void setListaUtilizadores(List<Utilizador> listaUtilizadores) {
        this.listaUtilizadores = listaUtilizadores;
    }
    
    public Utilizador getUtilizadorPorEmail(String email){
        for (Utilizador u : listaUtilizadores){
            if (u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }
    
}
