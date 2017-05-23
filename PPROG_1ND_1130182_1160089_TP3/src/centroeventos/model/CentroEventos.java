package centroeventos.model;

import java.util.ArrayList;
import java.util.List;
import centroeventos.model.RegistoEventos;
import centroeventos.model.Evento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class CentroEventos {

    private static CentroEventos centroEventos = new CentroEventos();
    private RegistoUtilizadores registoUtilizadores = RegistoUtilizadores.getRegistoUtilizadores();
    private RegistoEventos registoEventos = RegistoEventos.getRegistoEventos();
    private List<AlgoritmoAtribuicao> listaAlgoritmos = new ArrayList();
    private List<FAE> listaFae = new ArrayList();
    private List<Organizador> listaOrganizadores = new ArrayList();
    private List<Participante> listaParticipantes = new ArrayList();
    private static final String NOME_FICHEIRO_TEXTO = "Utilizadores.txt";

    private CentroEventos() {

    }

    public static CentroEventos getCentroEventos() {
        return centroEventos;
    }

    public RegistoEventos getRegistoEventos() {
        return registoEventos;
    }

    public RegistoUtilizadores getRegistoUtilizadores() {
        return registoUtilizadores;
    }

    public void setRegistoEventos(RegistoEventos registoEventos) {
        this.registoEventos = (RegistoEventos) RegistoEventos.getListaEventos();
    }

    /**
     * @return the listaFae
     */
    public List<FAE> getListaFae() {
        return listaFae;
    }

    /**
     * @return the listaOrganizadores
     */
    public List<Organizador> getListaOrganizadores() {
        return listaOrganizadores;
    }

    /**
     * @return the listaParticipantes
     */
    public List<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    /**
     * @param listaFae the listaFae to set
     */
    public void setListaFae(List<FAE> listaFae) {
        this.listaFae = listaFae;
    }

    /**
     * @param listaOrganizadores the listaOrganizadores to set
     */
    public void setListaOrganizadores(List<Organizador> listaOrganizadores) {
        this.listaOrganizadores = listaOrganizadores;
    }

    /**
     * @param listaParticipantes the listaParticipantes to set
     */
    public void setListaParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public void addFae(FAE fae) {
        listaFae.add(fae);
    }

    public void addOrganizador(Organizador org) {
        listaOrganizadores.add(org);
    }

    public void addParticipante(Participante par) {
        listaParticipantes.add(par);
    }

    public FAE novoFAE(Utilizador uFAE, String nome) {
        return new FAE(uFAE, nome);
    }
    
    public Organizador novoOrganizador(Utilizador uOrganizador, String nome) {
        return new Organizador(uOrganizador, nome);
    }

    public Participante novoParticipante(Utilizador uParticipante, String nome) {
        return new Participante(uParticipante, nome);
    }

    public boolean carregarRoles() {
        try {
            FileReader fileReader = new FileReader(new File(NOME_FICHEIRO_TEXTO));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int i =0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arrayLinha = line.split(";");
                //int i = Integer.parseInt(arrayLinha[0]);
                i++;
                if (i < 5) {
                    Utilizador utilizador = getRegistoUtilizadores().getUtilizadorPorEmail(arrayLinha[1]);
                    FAE f = novoFAE(utilizador,arrayLinha[3]);
                    listaFae.add(f);
                }
                else if(i<10){
                    Utilizador utilizador = getRegistoUtilizadores().getUtilizadorPorEmail(arrayLinha[1]);
                    Organizador org = novoOrganizador(utilizador,arrayLinha[3]);
                    listaOrganizadores.add(org);
                }
                else{
                    Utilizador utilizador = getRegistoUtilizadores().getUtilizadorPorEmail(arrayLinha[1]);
                    Participante par = novoParticipante(utilizador,arrayLinha[3]);
                    listaParticipantes.add(par);
                }

            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
