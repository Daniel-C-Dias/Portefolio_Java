
package TP3;

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
    
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String NOME = "nome";
    
//    public enum Role{ 
//       Gestor_Eventos{ public String toString() { return "Gestor de Eventos"; }},
//       Organizador{ public String toString() { return "Organizador"; }},
//       FAE { public String toString() { return "Funcionário de Apoio ao Evento"; }},
//       Participante{ public String toString() { return "Participante"; }},
//       Representante_Participante{ public String toString() { return "Representante do Participante"; }},
//       Sem_Role{ public String toString() { return "Sem Role"; }},
//    }  
//    
//    List <Role> rolesUtilizador = new ArrayList();

    
     /**
     * @Construtor por defeito
     */
    public Utilizador() {
        this.userName = USERNAME;
        this.email = EMAIL;
        this.password = PASSWORD;
        this.nome = NOME;
    }
    
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


