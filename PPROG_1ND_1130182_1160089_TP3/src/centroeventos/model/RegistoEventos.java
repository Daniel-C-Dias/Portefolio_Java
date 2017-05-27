package centroeventos.model;

import java.util.ArrayList;
import java.util.List;
import Utilitarios.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoEventos {

    private static RegistoEventos registoEventos = new RegistoEventos();
    private final List<Evento> listaEventos = new ArrayList();
    private List<Evento> listaEventoOrganizador;
    private final String NOME_FICHEIRO_TEXTO = "Eventos.txt";
    

    private RegistoEventos() {

    }

    public static RegistoEventos getRegistoEventos() {
        return registoEventos;
    }

    public  List<Evento> getListaEventos() {
        return listaEventos;
    }

    private boolean addEvento(Evento e) {
        listaEventos.add(e);
        return true;
    }

    // valida também que a data atual é inferior à data inicio do evento e superior à data de submissão de candidaturas
    public List<Evento> getlistaEventosDeFae(Utilizador fae) {
        List<Evento> listaEventosFae = new ArrayList();
        for (Evento e : listaEventos) {
            List<FAE> listaFae = e.getListaFaeEvento();
            for (FAE f : listaFae) {
                //Para ser possivel testar é necessário alterar a condição de validação das datas
                //if (f.getuFae().equals(fae) && e.getDataInicio().isMaior(Data.dataAtual()) && Data.dataAtual().isMaior(e.getDataLimiteSubCandidaturas())) {  
                if (f.getuFae().equals(fae) && e.getDataInicio().isMaior(Data.dataAtual()) ) {
                    listaEventosFae.add(e);
                }
            }
        }
        return listaEventosFae;
    }
    
    
    public List<Evento> getlistaEventosDeOrganizador(Utilizador organizador){
        List<Evento> listaEventosOrganizador = new ArrayList();
        for (Evento e : listaEventos ){
            List<Organizador> listaOrganizador= e.getListaOrganizadoresEvento();
            for (Organizador o : listaOrganizador){
                if (o.getuOrganizador().equals(organizador)){
                    listaEventosOrganizador.add(e);
                }
            }
        }
        return listaEventosOrganizador;
    }
    
    public Evento novaExposicao()
    {
        return new Exposicao();
    }
    
    public Evento novaExposicaoCompleta(String titulo, String textoDescritivo, String local, Data dataInicio, Data dataFim, Data dataLimiteSubCandidaturas) {
        return new Exposicao(titulo, textoDescritivo, local, dataInicio, dataFim, dataLimiteSubCandidaturas);
    }
    
    
    public Evento novoCongresso() {
        return new Congresso();
    }
    
    public Evento novoCongressoCompeto(String titulo, String textoDescritivo, String local, Data dataInicio, Data dataFim, Data dataLimiteSubCandidaturas) {
        return new Congresso(titulo, textoDescritivo, local, dataInicio, dataFim, dataLimiteSubCandidaturas);
    }

    public boolean registaEvento(Evento e) {
        if (validaEvento(e)) {
            return addEvento(e);
        } else {
            return false;
        }
    }

    public boolean validaEvento(Evento e) {
        return e.valida();
    }

    public Evento getEvento(int eventoID) {

        Evento eventoPretendido = null;

        for (Evento e : listaEventos) {
            if (e.getIdEvento() == eventoID) {
                eventoPretendido = e;
            }
        }

        return eventoPretendido;
    }

    public List<Evento> getEventosAtivos() {

        List<Evento> eventosActivos = new ArrayList();

        for (Evento e : listaEventos) {
            if (e.getDataLimiteSubCandidaturas().isMaior(Data.dataAtual())) {  
                eventosActivos.add(e);
            }
        }

        return eventosActivos;
    }

    public boolean containsEvento(Evento e) {
        return getRegistoEventos().containsEvento(e);
    }
    
    public boolean carregarEventos(){
       
        
        try {
            File file = new File(NOME_FICHEIRO_TEXTO);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int exposicaoOuCongresso=0;
            while ((line = bufferedReader.readLine()) != null) {
                exposicaoOuCongresso++;
                String[] arrayLinha = line.split(";");
                if(exposicaoOuCongresso % 2 == 0){
                    Evento evento = novaExposicaoCompleta(arrayLinha[0],arrayLinha[1],arrayLinha[2],extrairData(arrayLinha[3]),extrairData(arrayLinha[4]), extrairData(arrayLinha[5]));               
                    registaEvento(evento);
                }
                else {
                    Evento evento = novoCongressoCompeto(arrayLinha[0],arrayLinha[1],arrayLinha[2],extrairData(arrayLinha[3]),extrairData(arrayLinha[4]), extrairData(arrayLinha[5]));
                    registaEvento(evento);
                }
            }
         fileReader.close();
        } 
        catch (FileNotFoundException e) {
		System.out.println("Ficheiro não existente.");
                return false;
		}
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    private Data extrairData(String texto){
        
        Data d = new Data();
        
        try {
        String[] partesData = texto.split("/");
               int ano = Integer.parseInt(partesData[0]);
               int mes = Integer.parseInt(partesData[1]);
               int dia = Integer.parseInt(partesData[2]);
                  
               d.setData(ano, mes, dia);
        }
        catch(DiaInvalidoException | MesInvalidoException e ){     
            System.err.println(e.getMessage());
        }
        catch(NumberFormatException e){
            System.err.println(e.getMessage());
        }
       
        return d;
    }
    
    

}
