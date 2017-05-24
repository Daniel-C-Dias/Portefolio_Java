package centroeventos.controller;

import centroeventos.model.Candidatura;
import centroeventos.model.Evento;
import centroeventos.model.CentroEventos;
import centroeventos.model.Participante;
import centroeventos.model.RegistoEventos;
import centroeventos.model.Representante;
import centroeventos.model.Utilizador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistarCandidaturaController {

    private final CentroEventos centroEventos;

    public RegistarCandidaturaController() {
        this.centroEventos = CentroEventos.getCentroEventos();
    }

    public List<Evento> getEventosActivos() {
        return centroEventos.getRegistoEventos().getEventosAtivos();
    }
    
    public List<Utilizador> getListaUtilizadores() {
        return centroEventos.getRegistoUtilizadores().getListaUtilizadores();
    }

   
    public boolean registarCandidatura(Evento eventoSelecionado, Utilizador utilizadorRepresentante, Utilizador utilizadorParticipante , String motivo) {
 
        Representante representante = centroEventos.novoRepresentante(utilizadorRepresentante);
        Participante participante = centroEventos.novoParticipante(utilizadorParticipante);
        centroEventos.getRegistoEventos().getRegistoEventos().getEvento(eventoSelecionado.getIdEvento()).addCandidatura(representante, participante, motivo);

        return true;
    }

}
