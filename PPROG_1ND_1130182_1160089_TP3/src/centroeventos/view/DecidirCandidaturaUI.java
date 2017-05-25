/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroeventos.view;

import centroeventos.controller.DecidirCandidaturaController;
import centroeventos.model.AtribuicaoCandidatura;
import centroeventos.model.Evento;
import centroeventos.model.Utilizador;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class DecidirCandidaturaUI extends JPanel {
    
    private Utilizador userContexto;
    private Evento eventoSelecionado;
    private AtribuicaoCandidatura candidaturaSelecionada;
    private JComboBox cbEventos;
    private JComboBox cbCandidaturas;
    private JPanel p2;
    private JPanel p3;
    private final DecidirCandidaturaController DECIDIR_CONTROLLER;
    private List<Evento> listaEventosFae;
    private final JPanel pCardLayout;
    private final CardLayout cardLayout;
    
    public DecidirCandidaturaUI(Utilizador userContexto, JPanel pCardLayout, CardLayout cardLayout){
       
       DECIDIR_CONTROLLER= new DecidirCandidaturaController();
       this.userContexto=userContexto; 
       this.pCardLayout=pCardLayout;
       this.cardLayout=cardLayout;
       this.setLayout(new GridLayout(3,1,10,10));
       JPanel p1= criarP1();
       p2= new JPanel();
       p3= new JPanel();
       
       add(p1);
       add(p2);
       add(p3);
       
    }
    
    private JPanel criarP1(){
        JPanel p = new JPanel();
        
        JLabel labelEv = new JLabel("Por favor selecione um evento!", JLabel.CENTER);
        cbEventos = criarCbEventos();
        cbEventos.setMaximumRowCount(4);
        JButton btEventos = criarBtEventos();
        
        p.add(labelEv);
        p.add(cbEventos);
        p.add(btEventos);
        
        return p;
    }
    
    private JPanel criarP2(){
        JPanel p = new JPanel();
        
        JLabel labelCan = new JLabel("Por favor selecione uma candidatura!", JLabel.CENTER);
        cbCandidaturas = criarCbCandidaturas();
        cbCandidaturas.setMaximumRowCount(4);
        JButton btCan = criarBtCan();
        
        p.add(labelCan);
        p.add(cbEventos);
        p.add(btCan);
        
        return p;
    }
    
    private JPanel criarP3(){
        JPanel p = new JPanel(new BorderLayout());
        
        JLabel labelCan = new JLabel("Por favor selecione uma candidatura!", JLabel.CENTER);
        cbCandidaturas = criarCbCandidaturas();
        cbCandidaturas.setMaximumRowCount(4);
        JButton btCan = criarBtCan();
        
        p.add(labelCan);
        p.add(cbEventos);
        p.add(btCan);
        
        return p;
    }
    
    private JComboBox criarCbEventos(){
        listaEventosFae =  DECIDIR_CONTROLLER.getListaEventosFAE(userContexto);
        ArrayList<String> listaEventosFaeString = new ArrayList();
        for (Evento e : listaEventosFae){
            listaEventosFaeString.add(e.getTitulo());
        }
        
        String[] arrayListaEventosFaeString = listaEventosFaeString.toArray(new String[0]);
        
        return new JComboBox(arrayListaEventosFaeString);
    }
    
    private JComboBox criarCbCandidaturas(){ // ESTOU NESTA LOGICA!!!!!!!!!!!!!!
        List <AtribuicaoCandidatura> listaCandidaturasEv = DECIDIR_CONTROLLER.getListaCandidaturasFAE(userContexto, eventoSelecionado.getIdEvento());
        AtribuicaoCandidatura[] arrayListaCandidaturasEv = listaCandidaturasEv.toArray(new AtribuicaoCandidatura[0]);
        
        return new JComboBox(arrayListaCandidaturasEv);
    }
    
    private JButton criarBtEventos(){
        JButton btn = new JButton("Evento Selecionado");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               for (Evento ev : listaEventosFae){
                  if (ev.getTitulo().equals(cbEventos.getSelectedItem())) {
                      eventoSelecionado= ev;
                  }
                }
               p2= criarP2();
               p2.revalidate(); //PERCEBER MELHOR
            }
        });
        
        return btn;
    }
    
    private JButton criarBtCan(){
        JButton btn = new JButton("Candidatura Selecionada");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int id = (Integer) cbCandidaturas.getSelectedItem();
               //candidaturaSelecionada= // chamada ao controller 
               //p3= criarP3();
              //p3.revalidate(); //PERCEBER MELHOR
            }
        });
        
        return btn;
    }
}
