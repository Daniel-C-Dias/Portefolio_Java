
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoCandidaturas {
    
    private static final RegistoCandidaturas registoCandidaturas = new RegistoCandidaturas();
    private List<Candidatura> listaCandidaturas = new ArrayList();
    
    private RegistoCandidaturas(){
        
    }
    
    /**
     *Garante que apenas exista uma instancia unica de Registo de Candidaturas
     * 
     * @return registoCandidaturas
     */
    public static RegistoCandidaturas getInstance() {
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
    
    
    public boolean add(Candidatura c) {
        getInstance().add(c);
        return true;
    }

    public Utilizador get(int index) {
        return getInstance().get(index);
    }
    
     public boolean containsCandidatura(Candidatura c) {
        return getInstance().containsCandidatura(c);
    }
    
//    private boolean addCandidatura(Candidatura c) {
//        listaCandidaturas.add(c);
//        return true;
//    }
    
    public boolean validaCandidatura(Candidatura c)
    {
        return c.valida();
    }
    
    public boolean registaCandidatura(Candidatura c)
    {
        if( validaCandidatura(c) )
            return add(c);
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
