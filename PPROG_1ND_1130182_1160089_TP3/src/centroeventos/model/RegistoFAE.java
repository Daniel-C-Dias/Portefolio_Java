
package centroeventos.model;

import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoFAE {
    
       private List<FAE> listaFAE;
   
   private static RegistoFAE registoFAE = new RegistoFAE();
   
    
    private RegistoFAE(){
        
    }
    
    
     public static RegistoFAE getInstance() {
      if(registoFAE == null) {
         registoFAE = new RegistoFAE();
      }
      return registoFAE;
    }
    
//    public static RegistoFAE getRegistoFAE( ) {
//       return registoFAE;
//   }

    public List<FAE> getListaFAE() {
        return listaFAE;
    }

    public void setListaOrganizadores(List<FAE> listaFAE) {
        this.listaFAE = listaFAE;
    }
    
    
    public boolean add(Utilizador u) {
        getListaFAE().add(new FAE(u));
        return true;
    }

    public FAE get(int index) {
        return getListaFAE().get(index);
    }
    
     public boolean containsUtilizador(Utilizador u) {
        return getListaFAE().contains(u);
    }
 
    
}
