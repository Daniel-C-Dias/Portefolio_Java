package centroeventos.controller;

import centroeventos.model.Candidatura;
import centroeventos.model.Evento;
import centroeventos.model.CentroEventos;
import centroeventos.model.Participante;
import centroeventos.model.RegistoEventos;
import centroeventos.model.RegistoCandidaturas;
import centroeventos.model.Representante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistarCandidaturaController {

    private CentroEventos centroEventos;
    private Evento eventoACandidatar;
    private List<Candidatura> listaCandidaturas;
    private Candidatura candidaturaARegistar;

    public RegistarCandidaturaController() {
        this.centroEventos = CentroEventos.getCentroEventos();
    }

    public List<Evento> getEventosActivos() {
        return centroEventos.getRegistoEventos().getEventosSubmissaoPronta();

    }

    public void setContexto(int eventoID) {
        this.eventoACandidatar = centroEventos.getRegistoEventos().getEvento(eventoID);
    }

    public void setDadosCandidatura(Representante representante, Participante participante) {
        listaCandidaturas = eventoACandidatar.getListaCandidaturasEvento();

        Candidatura a = new Candidatura();

        if (a.valida()) {
            a.setIdCandidatura(listaCandidaturas.size());
            a.setRepresentante(representante);
            a.setParticipante(participante);
        }

        this.candidaturaARegistar = a;

    }

    public boolean registarCandidatura() {

        boolean result;

        if (RegistoCandidaturas.getInstance().registaCandidatura(this.candidaturaARegistar)) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

}
