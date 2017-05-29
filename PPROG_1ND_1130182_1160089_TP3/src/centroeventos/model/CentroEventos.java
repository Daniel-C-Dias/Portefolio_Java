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
    private List<Representante> listaRepresentantes = new ArrayList();
    
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
    }    /**
     * @return the listaAlgoritmos
     */
    public List<AlgoritmoAtribuicao> getListaAlgoritmos() {
        return listaAlgoritmos;
    }

    /**
     * @return the listaRepresentantes
     */
    public List<Representante> getListaRepresentantes() {
        return listaRepresentantes;
    }

    /**
     * @param listaAlgoritmos the listaAlgoritmos to set
     */
    public void setListaAlgoritmos(List<AlgoritmoAtribuicao> listaAlgoritmos) {
        this.listaAlgoritmos = listaAlgoritmos;
    }

    /**
     * @param listaRepresentantes the listaRepresentantes to set
     */
    public void setListaRepresentantes(List<Representante> listaRepresentantes) {
        this.listaRepresentantes = listaRepresentantes;
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
    
    public void addAlgoritmo(AlgoritmoAtribuicao alg) {
        listaAlgoritmos.add(alg);
    }

    public FAE novoFAE(Utilizador uFAE) {
        return new FAE(uFAE);
    }
    
    public Representante novoRepresentante(Utilizador uRepresentante) {
        return new Representante(uRepresentante);
    }
    
    public Organizador novoOrganizador(Utilizador uOrganizador) {
        return new Organizador(uOrganizador);
    }

    public Participante novoParticipante(Utilizador uParticipante) {
        return new Participante(uParticipante);
    }

    public boolean carregarRoles() {
        try {
            FileReader fileReader = new FileReader(new File(NOME_FICHEIRO_TEXTO));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int i =0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arrayLinha = line.split(";");
                
                if (i < 5) {
                    Utilizador utilizador = getRegistoUtilizadores().getUtilizadorPorEmail(arrayLinha[1]);
                    FAE f = novoFAE(utilizador);
                    listaFae.add(f);
                }
                else if(i<10){ 
                    Utilizador utilizador = getRegistoUtilizadores().getUtilizadorPorEmail(arrayLinha[1]);
                    Organizador org = novoOrganizador(utilizador);
                    listaOrganizadores.add(org);
                }
                else if(i<13) {
                    Utilizador utilizador = getRegistoUtilizadores().getUtilizadorPorEmail(arrayLinha[1]);
                    Participante par = novoParticipante(utilizador);
                    listaParticipantes.add(par);
                }
                else{
                    Utilizador utilizador = getRegistoUtilizadores().getUtilizadorPorEmail(arrayLinha[1]);
                    Representante rep = novoRepresentante(utilizador);
                    getListaRepresentantes().add(rep);  
                }
              i++;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean associarRolesAEventos(){
        List <Evento> listaEv = registoEventos.getListaEventos();
        
         for (Evento ev : listaEv){
            for (FAE fae :listaFae){
              ev.addFAE(fae);
            }
            for (Organizador org :listaOrganizadores){
              ev.addOrganizador(org);
            }
        }
           for (Evento ev : listaEv){System.out.println(ev.toString());}
           return true;
    }
    
    }

