
package centroeventos.model;

import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoOrganizadores {

    private List<Organizador> listaOrganizadores;
   
   private static RegistoOrganizadores registoOrganizadores = new RegistoOrganizadores();
   
    
    private RegistoOrganizadores(){
        
    }
    
    public static RegistoOrganizadores getInstance() {
      if(registoOrganizadores == null) {
         registoOrganizadores = new RegistoOrganizadores();
      }
      return registoOrganizadores;
    }
    
//    public static RegistoOrganizadores getRegistoOrganizadores( ) {
//       return registoOrganizadores;
//   }

    public List<Organizador> getListaOrganizadores() {
        return listaOrganizadores;
    }

    public void setListaOrganizadores(List<Organizador> listaOrganizadores) {
        this.listaOrganizadores = listaOrganizadores;
    }
    
    
    public boolean add(Utilizador u) {
        getListaOrganizadores().add(new Organizador(u));
        return true;
    }

    public Organizador get(int index) {
        return getListaOrganizadores().get(index);
    }
    
     public boolean containsUtilizador(Utilizador u) {
        return getListaOrganizadores().contains(u);
    }
 
}
