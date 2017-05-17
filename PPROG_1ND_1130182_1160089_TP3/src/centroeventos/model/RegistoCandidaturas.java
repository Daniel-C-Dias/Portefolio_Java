
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoCandidaturas {
    
    private List<Candidatura> listaCandidaturas;
    
    /**
     *
     * @return listaCandidaturas
     */
    public List<Candidatura> getListaCandidaturas() {
        return listaCandidaturas;
    }
    
    public List<Candidatura> getCandidaturaPorId(int idCandidatura){
        
        ArrayList<Candidatura> listaCandidaturasPorID = null; //necessário para inicializar
        
        for(Candidatura c : listaCandidaturas){
            if(c.getIdCandidatura() == idCandidatura)
            {listaCandidaturasPorID.add(c);}
        }
        
        return listaCandidaturasPorID;
    }

    
    
    
    
}
