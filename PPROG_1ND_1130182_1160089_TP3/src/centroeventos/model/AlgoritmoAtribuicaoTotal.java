
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.util.Pair;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class AlgoritmoAtribuicaoTotal implements AlgoritmoAtribuicao{

    private String nomeAlgoritmo;
    private Evento evento;
    
    public AlgoritmoAtribuicaoTotal(String nomeAlgoritmo, Evento evento){
        this.nomeAlgoritmo=nomeAlgoritmo;
        this.evento=evento;
    }
    
     /**
     * @return the nomeAlgoritmo
     */
    @Override
    public String getNomeAlgoritmo() {
        return nomeAlgoritmo;
    }

    /**
     * @return the evento
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * @param nomeAlgoritmo the nomeAlgoritmo to set
     */
    public void setNomeAlgoritmo(String nomeAlgoritmo) {
        this.nomeAlgoritmo = nomeAlgoritmo;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    
    //Atribui todas as candidadaturas a um dos FAE
    @Override
    public List<Pair<Candidatura, FAE>> atribui() {
        
        List<FAE> listaFaeEvento = evento.getListaFaeEvento();
        List<Candidatura> listaCandidaturaEvento = evento.getListaCandidaturasEvento();
        List<Pair<Candidatura, FAE>> listaAtribuicoes = new ArrayList();
        
        Random geradorAleatorio = new Random();
        int indiceFae = geradorAleatorio.nextInt(listaFaeEvento.size());
        
        for (Candidatura cand : listaCandidaturaEvento){
            listaAtribuicoes.add( new Pair<>(cand, listaFaeEvento.get(indiceFae)));
        }
               
        return listaAtribuicoes;
    }

   
}
