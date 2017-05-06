/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3;

import java.util.ArrayList;
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
private List <Organizador> listaOrganizadoresEvento;
private List <Candidatura> listaCandidaturasEvento;
private List <AtribuicaoCandidatura> listaAtribuicoes = new ArrayList();
private List <FAE> listaFaeEvento;

public void setPeriodo(Data dataInicio, Data dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

public void addOrganizador(Utilizador u)
    {
        Organizador org = new Organizador();
        org.setUtilizador(u);
        if (validaOrganizador(org))
            addOrganizador(org);
    }
    

    public boolean validaOrganizador(Organizador o)
    {
        if (o.valida())
        {
            // Introduzir as validações aqui
            return true;
        }
        return false;
    }
    
    
public boolean valida()
    {
        // Introduzir as validações aqui
        return true;
    }
   
 
    private boolean addOrganizador(Organizador o)
    {
        return this.listaOrganizadoresEvento.add(o);
    }
    
 
   @Override
    public String toString()
    {
        String sTxt;
        sTxt = String.format("%s;%s;%s;%s%s;\n", this.titulo,this.textoDescritivo,this.dataInicio.toString(),this.dataFim.toString(),this.dataLimiteSubCandidaturas.toString(),this.local);
         
        for(Organizador org: this.listaOrganizadoresEvento)
        {
            sTxt += String.format("%s \n",org.toString());
        }
        
        return sTxt;
    }
}




