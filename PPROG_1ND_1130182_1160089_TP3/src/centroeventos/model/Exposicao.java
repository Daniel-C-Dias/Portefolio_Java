/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroeventos.model;

import Utilitarios.Data;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class Exposicao extends Evento{
    
    public Exposicao(){}
    
    public Exposicao(String titulo, String textoDescritivo, String local, Data dataInicio, Data dataFim, Data dataLimiteSubCandidaturas, List<Organizador> listaOrganizadoresEvento, List<Candidatura> listaCandidaturasEvento, List<FAE> listaFaeEvento) {
        super(titulo, textoDescritivo, local, dataInicio, dataFim, dataLimiteSubCandidaturas, listaOrganizadoresEvento, listaCandidaturasEvento, listaFaeEvento);
    }
    
    public Exposicao(String titulo, String textoDescritivo, String local, Data dataInicio, Data dataFim, Data dataLimiteSubCandidaturas) {
        super(titulo, textoDescritivo, local, dataInicio, dataFim, dataLimiteSubCandidaturas);
    }
    
}
