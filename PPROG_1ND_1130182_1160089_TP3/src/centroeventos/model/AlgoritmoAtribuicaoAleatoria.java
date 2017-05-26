
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.util.Pair;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class AlgoritmoAtribuicaoAleatoria implements AlgoritmoAtribuicao{

   private String nomeAlgoritmo;
    private Evento evento;
    
    public AlgoritmoAtribuicaoAleatoria(String nomeAlgoritmo, Evento evento){
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

    // atribui aleatoriamente cada candidatura a 2 FAEs diferentes
    @Override
    public List<Pair<Candidatura, FAE>> atribui() {
        List<FAE> listaFaeEvento = evento.getListaFaeEvento();
        List<Candidatura> listaCandidaturaEvento = evento.getListaCandidaturasEvento();
        List<Pair<Candidatura, FAE>> listaAtribuicoes = new ArrayList();
        
        for (Candidatura cand : listaCandidaturaEvento){
            Random geradorAleatorio = new Random();
            listaAtribuicoes.add( new Pair<>(cand, listaFaeEvento.get(geradorAleatorio.nextInt(listaFaeEvento.size()))));
            
            //atribuição a um segundo FAE
            Pair<Candidatura, FAE> segundaAtribuicao = new Pair<>(cand, listaFaeEvento.get(geradorAleatorio.nextInt(listaFaeEvento.size())));
            while(listaAtribuicoes.contains(segundaAtribuicao)){
                segundaAtribuicao = new Pair<>(cand, listaFaeEvento.get(geradorAleatorio.nextInt(listaFaeEvento.size())));
            }
            listaAtribuicoes.add(segundaAtribuicao);
        }
        
        return listaAtribuicoes;
    }
}
