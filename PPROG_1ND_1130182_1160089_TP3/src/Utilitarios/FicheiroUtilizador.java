
package Utilitarios;

import centroeventos.model.RegistoUtilizadores;
import centroeventos.model.Utilizador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class FicheiroUtilizador {
    
    public RegistoUtilizadores registoUtilizadores = RegistoUtilizadores.getRegistoUtilizadores();
    
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
                Utilizador utilizador = new Utilizador(arrayLinha[0],arrayLinha[1],arrayLinha[2],arrayLinha[3]);
                registoUtilizadores.add(utilizador);
                stringBuffer.append("\n");
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
     
}
