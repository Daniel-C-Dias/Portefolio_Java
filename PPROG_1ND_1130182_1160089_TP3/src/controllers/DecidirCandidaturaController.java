/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import TP3.AtribuicaoCandidatura;
import TP3.CentroEventos;
import TP3.Evento;
import TP3.Utilizador;
import java.util.List;

/**
 *
 * @author gonca
 */
public class DecidirCandidaturaController {
    
    private CentroEventos centroEventos;
    

    public DecidirCandidaturaController(CentroEventos centroEventos)
    {
        this.centroEventos= centroEventos;
    }
    
    public List<Evento> getListaEventosFAE(Utilizador uFae){
        return centroEventos.getRegistoEventos().getlistaEventosDeFae(uFae);
    }
    
    public List<AtribuicaoCandidatura> getListaCandidaturasFAE(Utilizador uFae, int idEvento){
        return centroEventos.getRegistoEventos().getEvento(idEvento).getListaAtribuicaoCandidaturasFAE(uFae);
    }
}
