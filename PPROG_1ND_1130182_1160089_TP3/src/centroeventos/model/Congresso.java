
package centroeventos.model;

import Utilitarios.Data;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class Congresso extends Evento{
    private List <Workshop> listaWorkshops = new ArrayList();
    
    public Congresso(){}
    
    public Congresso(int idEvento, String titulo, String textoDescritivo, String local, Data dataInicio, Data dataFim, Data dataLimiteSubCandidaturas, List<Organizador> listaOrganizadoresEvento, List<Candidatura> listaCandidaturasEvento, List<FAE> listaFaeEvento, List <Workshop> listaWorkshops ) {
        super(idEvento, titulo, textoDescritivo, local, dataInicio, dataFim, dataLimiteSubCandidaturas, listaOrganizadoresEvento, listaCandidaturasEvento, listaFaeEvento);
        this.listaWorkshops=listaWorkshops;
    }

    /**
     * @return the listaWorkshops
     */
    public List <Workshop> getListaWorkshops() {
        return listaWorkshops;
    }

    /**
     * @param listaWorkshops the listaWorkshops to set
     */
    public void setListaWorkshops(List <Workshop> listaWorkshops) {
        this.listaWorkshops = listaWorkshops;
    }
    
}
