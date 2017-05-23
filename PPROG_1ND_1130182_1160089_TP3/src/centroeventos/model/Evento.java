
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;
import Utilitarios.Data;
import java.io.Serializable;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public abstract class Evento implements Serializable {

    private int idEvento;
    private String titulo;
    private String textoDescritivo;
    private String local;
    private Data dataInicio;
    private Data dataFim;
    private Data dataLimiteSubmissaoCandidaturas;
    private List<Organizador> listaOrganizadoresEvento;
    private List<Candidatura> listaCandidaturasEvento;
    private List<AtribuicaoCandidatura> listaAtribuicoes;
    private List<FAE> listaFaeEvento;
    private static int contaEvento = 1;
    
    public Evento(){
        List<Organizador> listaOrganizadoresEvento= new ArrayList();
        List<Candidatura> listaCandidaturasEvento= new ArrayList();
        List<AtribuicaoCandidatura> listaAtribuicoes = new ArrayList();
        List<FAE> listaFaeEvento= new ArrayList();
        this.idEvento = contaEvento;
        contaEvento++;
    }
    
    /**
     *
     * @param titulo
     * @param textoDescritivo
     * @param local
     * @param dataInicio
     * @param dataFim
     * @param dataLimiteSubCandidaturas
     * @param listaOrganizadoresEvento
     * @param listaCandidaturasEvento
     * @param listaFaeEvento
     */
    public Evento(String titulo, String textoDescritivo, String local, Data dataInicio, Data dataFim, Data dataLimiteSubCandidaturas, List<Organizador> listaOrganizadoresEvento, List<Candidatura> listaCandidaturasEvento, List<FAE> listaFaeEvento) {
        this.idEvento = contaEvento;
        this.titulo = titulo;
        this.textoDescritivo = textoDescritivo;
        this.local = local;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataLimiteSubmissaoCandidaturas = dataLimiteSubCandidaturas;
        this.listaOrganizadoresEvento = listaOrganizadoresEvento;
        this.listaCandidaturasEvento = listaCandidaturasEvento;
        this.listaFaeEvento = listaFaeEvento;
        contaEvento++;
    }
    
    public Evento(String titulo, String textoDescritivo, String local, Data dataInicio, Data dataFim, Data dataLimiteSubCandidaturas){
        this.idEvento = contaEvento;
        this.titulo = titulo;
        this.textoDescritivo = textoDescritivo;
        this.local = local;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataLimiteSubmissaoCandidaturas = dataLimiteSubCandidaturas;
        this.listaOrganizadoresEvento = new ArrayList();
        this.listaCandidaturasEvento = new ArrayList();
        this.listaFaeEvento = new ArrayList();
        contaEvento++;
    }
    
    /**
     * @return the idEvento
     */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * @return titulo
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
     * @return the dataLimiteSubmissaoCandidaturas
     */
    public Data getDataLimiteSubCandidaturas() {
        return dataLimiteSubmissaoCandidaturas;
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
     * @param dataLimiteSubCandidaturas the dataLimiteSubmissaoCandidaturas to set
     */
    public void setDataLimiteSubCandidaturas(Data dataLimiteSubCandidaturas) {
        this.dataLimiteSubmissaoCandidaturas = dataLimiteSubCandidaturas;
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
    
    public void addFAE(Utilizador u) {
        FAE fae = new FAE();
        fae.setuFae(u);
        if (validaFAE(fae)) {
            addFAE(fae);
        }
    }

    public boolean validaFAE(FAE f) {
        if (f.valida()) {
            // Introduzir as validações aqui
            return true;
        }
        return false;
    }

  
    private boolean addFAE(FAE f) {
        return this.getListaFaeEvento().add(f);
    }
    
    
   
    public List<AtribuicaoCandidatura> getListaAtribuicaoCandidaturasFAE(Utilizador uFae){
        List<AtribuicaoCandidatura> listaAtribuicaoCandidaturasFae = new ArrayList();
        for (AtribuicaoCandidatura atribuicao : listaAtribuicoes){
             //valida que ainda não foi avaliada (ainda não tem decisão)   
            if (atribuicao.getFae().getuFae().equals(uFae) && atribuicao.getDecisao()==null ){
                    listaAtribuicaoCandidaturasFae.add(atribuicao);
                }
            }
        return listaAtribuicaoCandidaturasFae;
    }
    
    public String toString() {
        String sTxt;
        sTxt = String.format("%s;%s;%s;%s%s;\n", this.getTitulo(), this.getTextoDescritivo(), this.getDataInicio().toString(), this.getDataFim().toString(), this.getDataLimiteSubCandidaturas().toString(), this.getLocal());

        for (Organizador org : this.getListaOrganizadoresEvento()) {
            sTxt += String.format("%s \n", org.toString());
        }

        return sTxt;
    }

}
