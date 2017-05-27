/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroeventos.controller;

import centroeventos.model.AtribuicaoCandidatura;
import centroeventos.model.CentroEventos;
import centroeventos.model.Evento;
import centroeventos.model.Utilizador;
import java.util.List;

/**
 *
 * @author gonca
 */
public class DecidirCandidaturaController {
    
    private final CentroEventos centroEventos;
    

    public DecidirCandidaturaController()
    {
        this.centroEventos= CentroEventos.getCentroEventos();
    }
    
    public List<Evento> getListaEventosFAE(Utilizador uFae){
        return centroEventos.getRegistoEventos().getlistaEventosDeFae(uFae);
    }
    
    public List<AtribuicaoCandidatura> getListaCandidaturasFAE(Utilizador uFae, int idEvento){
        return centroEventos.getRegistoEventos().getEvento(idEvento).getListaAtribuicaoCandidaturasFAE(uFae);
    }
    
    public String getMotivoCandidatura(Evento evento, int idCandidatura){
        return centroEventos.getRegistoEventos().getEvento(evento.getIdEvento()).getCandidaturaPorId(idCandidatura).getMotivo();
    }
    
    public boolean registarDecisao(Evento evento, AtribuicaoCandidatura atribuicao, boolean aceita, String motivo ){
        centroEventos.getRegistoEventos().getEvento(evento.getIdEvento()).getAtribuicaoCandidaturaPorID(atribuicao.getIdAtribuicao()).getDecisao().setJaAvaliada(true);
        centroEventos.getRegistoEventos().getEvento(evento.getIdEvento()).getAtribuicaoCandidaturaPorID(atribuicao.getIdAtribuicao()).getDecisao().setAceite(aceita);
        centroEventos.getRegistoEventos().getEvento(evento.getIdEvento()).getAtribuicaoCandidaturaPorID(atribuicao.getIdAtribuicao()).getDecisao().setJustificacaoDecisao(motivo);
        
        return true;
    }
}
