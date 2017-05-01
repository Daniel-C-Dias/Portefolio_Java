/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3;

import java.util.List;
import utilitarios.Data;

/**
 *
 * @author gonca
 */
public abstract class Evento {
    
private String titulo;
private String textoDescritivo;
private String local;
private Data dataInicio;
private Data dataFim;
private Data dataLimiteSubCandidaturas;
List <String> listaOrganizadoresEvento;
List <Candidatura> listaCandidaturasEvento;
List <Utilizador> listaFaeEvento;

}
