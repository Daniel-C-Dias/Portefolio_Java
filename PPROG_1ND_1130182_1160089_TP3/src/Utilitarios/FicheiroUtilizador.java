
package Utilitarios;

import centroeventos.model.Utilizador;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class FicheiroUtilizador {
    
    public static final String NOME_FICHEIRO_BINARIO = "Utilizadores.bin";
    public static final String NOME_FICHEIRO_TEXTO = "Utilizadores.txt";

    public FicheiroUtilizador() {
    }
    
    public Utilizador lerBinario() {
        Utilizador utilizador;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(NOME_FICHEIRO_BINARIO));
            try {
                utilizador = (Utilizador) in.readObject();
            } finally {
                in.close();
            }
            return utilizador;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    public boolean guardarBinario(Utilizador utilizador) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(NOME_FICHEIRO_BINARIO));
            try {
                out.writeObject(utilizador);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
     
}
