
package centroeventos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class Utilizador implements Serializable{
    
    private String userName;
    private String email;
    private String password;
    private String nome;
    
    public Utilizador (){} 
    
    /**
     * @Construtor por inteiro
     */
    public Utilizador(String userName, String email, String password, String nome) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.nome = nome;
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
    
    public boolean validarAutenticacao(String email, String password){
       return (this.email.equals(email)&& this.password.equals(password));
    }
    
    @Override
    public String toString()
    {
        return "Utilizador: " + this.nome + " - " + this.email;
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        Utilizador u = (Utilizador) outroObjeto;
        return this.userName == u.getUserName() && 
                this.email == u.getEmail() && 
                this.password == u.getPassword() &&
                this.nome == u.getNome();
    }
    
    
}


