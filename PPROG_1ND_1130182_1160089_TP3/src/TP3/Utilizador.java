/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gonca
 */
public class Utilizador {
    
    private String userName;
    private String email;
    private String password;
    private String nome;
    
    public enum Role{ 
       Gestor_Eventos{ public String toString() { return "Gestor de Eventos"; }},
       Organizador{ public String toString() { return "Organizador"; }},
       FAE { public String toString() { return "Funcionário de Apoio ao Evento"; }},
       Participante{ public String toString() { return "Participante"; }},
       Representante_Participante{ public String toString() { return "Representante do Participante"; }},
       Sem_Role{ public String toString() { return "Sem Role"; }},
    }  
    
    List <Role> rolesUtilizador = new ArrayList();
    
    
}
