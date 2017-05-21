
package Utilitarios;


import centroeventos.model.Evento;
import centroeventos.model.RegistoEventos;
import centroeventos.view.MenuUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class FicheiroEvento {
    
    public RegistoEventos registoEvento = RegistoEventos.getRegistoEventos();
    
    public static final String NOME_FICHEIRO_BINARIO = "Eventos.bin";
    public static final String NOME_FICHEIRO_TEXTO = "Eventos.txt";

    public FicheiroEvento() {
    }
    
    public Evento lerBinario() {
        Evento evento;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(NOME_FICHEIRO_BINARIO));
            try {
                evento = (Evento) in.readObject();
            } finally {
                in.close();
            }
            return evento;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    public boolean guardarBinario(Evento evento) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(NOME_FICHEIRO_BINARIO));
            try {
                out.writeObject(evento);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public boolean lerTexto() {
        try {
            File file = new File(NOME_FICHEIRO_TEXTO);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                String[] arrayLinha = stringBuffer.toString().split(";");
                Evento evento = new Evento(arrayLinha[0],arrayLinha[1],arrayLinha[2],extrairData(arrayLinha[3]),extrairData(arrayLinha[4]), extrairData(arrayLinha[5]));
                registoEvento.registaEvento(evento);
                stringBuffer.append("\n");
            }
            fileReader.close();
        } catch (IOException e) {
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
