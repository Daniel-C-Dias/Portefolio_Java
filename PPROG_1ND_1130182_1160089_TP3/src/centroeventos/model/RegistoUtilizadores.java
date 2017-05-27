
package centroeventos.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistoUtilizadores {
    
    
   private final List<Utilizador> listaUtilizadores = new ArrayList();
   
   private static RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();
   private static final String NOME_FICHEIRO_TEXTO = "Utilizadores.txt";
   public static final String NOME_FICHEIRO_BINARIO = "Utilizadores.bin";
    
    private RegistoUtilizadores(){
        
    }
    
    public static RegistoUtilizadores getRegistoUtilizadores( ) {
       return registoUtilizadores;
   }
    
    public Utilizador novoUtilizadorCompleto(String userName, String email, String password, String nome) {
        return new Utilizador( userName, email, password, nome);
    }
   
    public boolean add(Utilizador u) {
        listaUtilizadores.add(u);
        return true;
    }

    public Utilizador get(int index) {
        return getListaUtilizadores().get(index);
    }
    
     public boolean containsUtilizador(Utilizador u) {
        return getListaUtilizadores().contains(u);
    }

    /**
     * @return the listaUtilizadores
     */
    public List<Utilizador> getListaUtilizadores() {
        return listaUtilizadores;
    }

   
    public Utilizador getUtilizadorPorEmail(String email){
        for (Utilizador u : listaUtilizadores){
            if (u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }
    
    public boolean carregarUtilizadores(){
        try { 
            FileReader fileReader = new FileReader(new File(NOME_FICHEIRO_TEXTO));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arrayLinha = line.split(";");
                Utilizador utilizador = novoUtilizadorCompleto(arrayLinha[0],arrayLinha[1],arrayLinha[2],arrayLinha[3]);
                System.out.println(arrayLinha[0]+arrayLinha[1]+arrayLinha[2]+arrayLinha[3]);
                registoUtilizadores.add(utilizador);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
        
    }
    
    public boolean guardarListaUtilizadores(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(NOME_FICHEIRO_BINARIO));
            try {
                out.writeObject(listaUtilizadores);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
