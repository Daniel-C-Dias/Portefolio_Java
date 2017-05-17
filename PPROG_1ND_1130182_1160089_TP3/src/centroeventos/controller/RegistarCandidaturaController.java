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

    private Evento e;
    private RegistoEventos er;
    private List<Evento> lsre;
    private List<Candidatura> al;

    public RegistarCandidaturaController() {
    }

    /**
     *
     * @param e
     * @param er
     * @param lsre
     * @param al
     */
    public RegistarCandidaturaController(Evento e, RegistoEventos er, List<Evento> lsre, List<Candidatura> al) {
        this.e = e;
        this.er = er;
        this.lsre = lsre;
        this.al = al;
    }

    public List<Evento> getEventosActivos() {
        this.er = CentroEventos.getRegistoEventos();
        lsre = er.getEventosSubmissaoPronta();

        return lsre;
    }

    public void setContext(int eventoID) {
        this.e = er.getEvento(eventoID);
    }

    public void setDadosCandidatura(Representante representante, Participante participante) {
        this.al = e.getListaCandidaturasEvento();

        Candidatura a = new Candidatura();

        if (a.valida()) {
            a.setIdCandidatura(al.size());
            a.setRepresentante(representante);
            a.setParticipante(participante);
        }

    }

    public void registarCandidatura() {
        

    }

}
