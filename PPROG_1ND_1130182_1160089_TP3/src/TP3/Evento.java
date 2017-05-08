/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3;

import java.util.ArrayList;
import java.util.List;
import utilitarios.Data;

/**
 *
 * @author gonca
 */
public abstract class Evento {

    private int idEvento;
    private String titulo;
    private String textoDescritivo;
    private String local;
    private Data dataInicio;
    private Data dataFim;
    private Data dataLimiteSubCandidaturas;
    private List<Organizador> listaOrganizadoresEvento;
    private List<Candidatura> listaCandidaturasEvento;
    private List<AtribuicaoCandidatura> listaAtribuicoes = new ArrayList();
    private List<FAE> listaFaeEvento;
    
    
    public Evento(){
        
    }

    public Evento(int idEvento, String titulo, String textoDescritivo, String local, Data dataInicio, Data dataFim, Data dataLimiteSubCandidaturas, List<Organizador> listaOrganizadoresEvento, List<Candidatura> listaCandidaturasEvento, List<FAE> listaFaeEvento) {
        this.idEvento = idEvento;
        this.titulo = titulo;
        this.textoDescritivo = textoDescritivo;
        this.local = local;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataLimiteSubCandidaturas = dataLimiteSubCandidaturas;
        this.listaOrganizadoresEvento = listaOrganizadoresEvento;
        this.listaCandidaturasEvento = listaCandidaturasEvento;
        this.listaFaeEvento = listaFaeEvento;
    }
    
    /**
     * Construtor de Cópia
     */
    public Evento(Evento outroEvento) {
		this.idEvento = outroEvento.idEvento;
                this.titulo = outroEvento.titulo;
                this.textoDescritivo = outroEvento.textoDescritivo;
                this.local = outroEvento.local;
                this.dataInicio = outroEvento.dataInicio;
                this.dataFim = outroEvento.dataFim;
                this.dataLimiteSubCandidaturas = outroEvento.dataLimiteSubCandidaturas;
                this.listaOrganizadoresEvento = outroEvento.listaOrganizadoresEvento;
                this.listaCandidaturasEvento = outroEvento.listaCandidaturasEvento;
                this.listaFaeEvento = outroEvento.listaFaeEvento;     	
	}

    /**
     * @return the idEvento
     */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return the textoDescritivo
     */
    public String getTextoDescritivo() {
        return textoDescritivo;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @return the dataInicio
     */
    public Data getDataInicio() {
        return dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Data getDataFim() {
        return dataFim;
    }

    /**
     * @return the dataLimiteSubCandidaturas
     */
    public Data getDataLimiteSubCandidaturas() {
        return dataLimiteSubCandidaturas;
    }

    /**
     * @return the listaOrganizadoresEvento
     */
    public List<Organizador> getListaOrganizadoresEvento() {
        return listaOrganizadoresEvento;
    }

    /**
     * @return the listaCandidaturasEvento
     */
    public List<Candidatura> getListaCandidaturasEvento() {
        return listaCandidaturasEvento;
    }

    /**
     * @return the listaAtribuicoes
     */
    public List<AtribuicaoCandidatura> getListaAtribuicoes() {
        return listaAtribuicoes;
    }

    /**
     * @return the listaFaeEvento
     */
    public List<FAE> getListaFaeEvento() {
        return listaFaeEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @param textoDescritivo the textoDescritivo to set
     */
    public void setTextoDescritivo(String textoDescritivo) {
        this.textoDescritivo = textoDescritivo;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @param dataLimiteSubCandidaturas the dataLimiteSubCandidaturas to set
     */
    public void setDataLimiteSubCandidaturas(Data dataLimiteSubCandidaturas) {
        this.dataLimiteSubCandidaturas = dataLimiteSubCandidaturas;
    }

    /**
     * @param listaOrganizadoresEvento the listaOrganizadoresEvento to set
     */
    public void setListaOrganizadoresEvento(List<Organizador> listaOrganizadoresEvento) {
        this.listaOrganizadoresEvento = listaOrganizadoresEvento;
    }

    /**
     * @param listaCandidaturasEvento the listaCandidaturasEvento to set
     */
    public void setListaCandidaturasEvento(List<Candidatura> listaCandidaturasEvento) {
        this.listaCandidaturasEvento = listaCandidaturasEvento;
    }

    /**
     * @param listaAtribuicoes the listaAtribuicoes to set
     */
    public void setListaAtribuicoes(List<AtribuicaoCandidatura> listaAtribuicoes) {
        this.listaAtribuicoes = listaAtribuicoes;
    }

    /**
     * @param listaFaeEvento the listaFaeEvento to set
     */
    public void setListaFaeEvento(List<FAE> listaFaeEvento) {
        this.listaFaeEvento = listaFaeEvento;
    }

    
    public void addOrganizador(Utilizador u) {
        Organizador org = new Organizador();
        org.setuOrganizador(u);
        if (validaOrganizador(org)) {
            addOrganizador(org);
        }
    }

    public boolean validaOrganizador(Organizador o) {
        if (o.valida()) {
            // Introduzir as validações aqui
            return true;
        }
        return false;
    }

    public boolean valida() {
        // Introduzir as validações aqui
        return true;
    }

    private boolean addOrganizador(Organizador o) {
        return this.getListaOrganizadoresEvento().add(o);
    }

    @Override
    public String toString() {
        String sTxt;
        sTxt = String.format("%s;%s;%s;%s%s;\n", this.getTitulo(), this.getTextoDescritivo(), this.getDataInicio().toString(), this.getDataFim().toString(), this.getDataLimiteSubCandidaturas().toString(), this.getLocal());

        for (Organizador org : this.getListaOrganizadoresEvento()) {
            sTxt += String.format("%s \n", org.toString());
        }

        return sTxt;
    }

}
