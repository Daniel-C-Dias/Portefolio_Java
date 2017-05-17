
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoCandidaturas {
    
    private List<Candidatura> listaCandidaturas;
    private static RegistoCandidaturas registoCandidaturas = null;
    
    private RegistoCandidaturas(){
        
    }
    
    /**
     *Isto tudo serve para garantir que a classe torna-se um singleton, retornando a instancia unica da lista que é o Registo de Candidaturas
     * 
     * @return registoCandidaturas
     */
    public static RegistoCandidaturas getInstance() {
      if(registoCandidaturas == null) {
         registoCandidaturas = new RegistoCandidaturas();
      }
      return registoCandidaturas;
    }
    
    /**
     *
     * @return listaCandidaturas
     */
    public List<Candidatura> getListaCandidaturas() {
        return listaCandidaturas;
        
    }

    public void setListaCandidaturas(List<Candidatura> listaCandidaturas) { //mudar este método de acordo com o que aprendemos durante o TP2
        this.listaCandidaturas = listaCandidaturas;
    }
    
    
    
    private boolean addCandidatura(Candidatura c) {
        listaCandidaturas.add(c);
        return true;
    }
    
    public boolean validaCandidatura(Candidatura c)
    {
        return c.valida();
    }
    
    public boolean registaCandidatura(Candidatura c)
    {
        if( validaCandidatura(c) )
            return addCandidatura(c);
        else
            return false;
    }
    
    public Candidatura getCandidaturaPorId(int idCandidatura){
        
        Candidatura candidaturaPretendida = new Candidatura();
        
        for(Candidatura c : listaCandidaturas){
            if(c.getIdCandidatura() == idCandidatura){
                candidaturaPretendida = c;
            }
        }
        
        return candidaturaPretendida;
    }

    
    
    
    
}
