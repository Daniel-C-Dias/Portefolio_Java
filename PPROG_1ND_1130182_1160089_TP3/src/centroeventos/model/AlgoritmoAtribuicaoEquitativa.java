package centroeventos.model;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;


/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class AlgoritmoAtribuicaoEquitativa implements AlgoritmoAtribuicao {
    private final String NOME_ALGORITMO="AlgoritmoAtribuicaoEquitativa";
    private String nomeAlgoritmo;
    private Evento evento;
    
    public AlgoritmoAtribuicaoEquitativa(String nomeAlgoritmo, Evento evento){
        this.nomeAlgoritmo=nomeAlgoritmo;
        this.evento=evento;
    }
    
    public AlgoritmoAtribuicaoEquitativa(Evento evento){
        this.nomeAlgoritmo=NOME_ALGORITMO;
        this.evento=evento;
    }
    
    public AlgoritmoAtribuicaoEquitativa(){
        this.nomeAlgoritmo=NOME_ALGORITMO;
        this.evento=null;
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
    @Override
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

       
    @Override
    public List<Pair<Candidatura, FAE>> atribui() {
        List<FAE> listaFaeEvento = evento.getListaFaeEvento();
        List<Candidatura> listaCandidaturaEvento = evento.getListaCandidaturasEvento();
        List<Pair<Candidatura, FAE>>listaAtribuicoes = new ArrayList();
        
        int nrFAEPorCandidatura = listaFaeEvento.size() / listaCandidaturaEvento.size(); //numero total de Fae a atribuir por candidatura
        int nrFAERestantes =listaFaeEvento.size() % listaCandidaturaEvento.size();

        if(nrFAEPorCandidatura>0){
            for (Candidatura cand : listaCandidaturaEvento){
               if(listaCandidaturaEvento.get(listaCandidaturaEvento.size()-1)!=cand){
                  for (int i=0; i<nrFAEPorCandidatura;i++){
                   listaAtribuicoes.add( new Pair<>(cand, listaFaeEvento.get(i))); 
                }
               } 
               else{
                  for (int i=0; i<nrFAEPorCandidatura+nrFAERestantes;i++){
                   listaAtribuicoes.add( new Pair<>(cand, listaFaeEvento.get(i))); 
                }
              }
            }
        }
        else{
            for (Candidatura cand : listaCandidaturaEvento){
                listaAtribuicoes.add( new Pair<>(cand, listaFaeEvento.get(0))); 
            }
        }
        return listaAtribuicoes;
    }

    
}
