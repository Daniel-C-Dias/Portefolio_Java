
package Utilitarios;

import centroeventos.model.Candidatura;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class FicheiroCandidatura {
    
    public static final String NOME_FICHEIRO_BINARIO = "Candidaturas.bin";
    public static final String NOME_FICHEIRO_TEXTO = "Candidaturas.txt";

    public FicheiroCandidatura() {
    }
    
    public Candidatura lerBinario() {
        Candidatura candidatura;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(NOME_FICHEIRO_BINARIO));
            try {
                candidatura = (Candidatura) in.readObject();
            } finally {
                in.close();
            }
            return candidatura;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    public boolean guardarBinario(Candidatura candidatura) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(NOME_FICHEIRO_BINARIO));
            try {
                out.writeObject(candidatura);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
}
