
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class Utilizador {
    
    private String userName;
    private String email;
    private String password;
    private String nome;
    
     
    /**
     * @Construtor por inteiro
     */
    public Utilizador(String userName, String email, String password, String nome) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.nome = nome;
    }
    
     /**
     * @Construtor de Cópia
     */
    public Utilizador(Utilizador outroUtilizador){
        this.userName = outroUtilizador.userName;
        this.email = outroUtilizador.email;
        this.password = outroUtilizador.password;
        this.nome = outroUtilizador.nome;
                
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    

    @Override
    public String toString()
    {
        return "Utilizador: " + this.nome + " - " + this.email;
    }
}


