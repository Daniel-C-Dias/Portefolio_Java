
package Utilitarios;

import centroeventos.model.Evento;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class FicheiroEvento {
    
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
    
}
