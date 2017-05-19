package Utilitarios;

import centroeventos.model.Candidatura;
import centroeventos.model.Participante;
import centroeventos.model.Representante;
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
                Candidatura candidatura = new Candidatura(new Representante(arrayLinha[0]), new Participante(arrayLinha[1])); //tenho que arranjar aqui forma de verificar a que utilizador o representante e participante pertencem 
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
