package centroeventos.controller;

import centroeventos.model.AlgoritmoAtribuicao;
import centroeventos.model.AlgoritmoAtribuicaoAleatoria;
import centroeventos.model.AlgoritmoAtribuicaoEquitativa;
import centroeventos.model.AlgoritmoAtribuicaoTotal;
import centroeventos.model.Candidatura;
import centroeventos.model.CentroEventos;
import java.util.List;
import centroeventos.model.Evento;
import centroeventos.model.FAE;
import centroeventos.model.Utilizador;
import javafx.util.Pair;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class AtribuirCandidaturaController {

    private final CentroEventos centroEventos;
    
    public AtribuirCandidaturaController() {
        this.centroEventos = CentroEventos.getCentroEventos();
    }
    

    public List<Evento> getEventosActivosOrganizador(Utilizador organizador) {
        return centroEventos.getRegistoEventos().getlistaEventosDeOrganizador(organizador);
    }
    
    public List<AlgoritmoAtribuicao> getListaAlgoritmos(Evento evento) {
        inicilizarAlgoritmos(evento);
        return centroEventos.getListaAlgoritmos();
    }

    private void inicilizarAlgoritmos(Evento evento){
        centroEventos.addAlgoritmo(new AlgoritmoAtribuicaoEquitativa("AlgoritmoAtribuicaoEquitativa", evento));
        centroEventos.addAlgoritmo(new AlgoritmoAtribuicaoTotal("AlgoritmoAtribuicaoTotal", evento));
        centroEventos.addAlgoritmo(new AlgoritmoAtribuicaoAleatoria("AlgoritmoAtribuicaoAleatoria", evento));
    }
    
    public boolean registarAtribuicoesCandidaturas(Evento evento, List<Pair<Candidatura, FAE>> listaAtrib) {
       return centroEventos.getRegistoEventos().getEvento(evento.getIdEvento()).registarAtribuicoesCandidaturas(listaAtrib);
    }
  
}
