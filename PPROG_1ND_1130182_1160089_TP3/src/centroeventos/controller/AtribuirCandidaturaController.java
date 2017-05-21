package centroeventos.controller;

import centroeventos.model.AlgoritmoAtribuicao;
import centroeventos.model.CentroEventos;
import java.util.List;
import centroeventos.model.Evento;
import centroeventos.model.Utilizador;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class AtribuirCandidaturaController {

    private final CentroEventos centroEventos;
    private static Evento evento;


    public AtribuirCandidaturaController() {
        this.centroEventos = CentroEventos.getCentroEventos();
    }

    public List<Evento> getEventosActivosOrganizador(Utilizador organizador) {
        return centroEventos.getRegistoEventos().getlistaEventosDeOrganizador(organizador);
    }

    public static void setEvento(Evento evento) {
        AtribuirCandidaturaController.evento = evento;
    }
  
}
