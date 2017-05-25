/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroeventos.view;

import centroeventos.controller.AtribuirCandidaturaController;
import centroeventos.controller.RegistarCandidaturaController;
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
public class AtribuirCandidaturaUI extends JPanel{
   
    private Utilizador utilizadorOrganizador;
    private final JPanel pCardLayout;
    private final CardLayout cardLayout;
    private List<Evento> listaEventosOrg;
    private final AtribuirCandidaturaController ATRIBUIR_CONTROLLER;
    private JComboBox cbEventos;
    private Evento eventoSelecionado;

    public AtribuirCandidaturaUI(Utilizador userContexto, JPanel pCardLayout, CardLayout cardLayout) {

        utilizadorOrganizador = userContexto;
        this.pCardLayout = pCardLayout;
        this.cardLayout = cardLayout;
        ATRIBUIR_CONTROLLER = new AtribuirCandidaturaController();
        
        setLayout(new BorderLayout(10,10));

        JPanel p1 = criarP1();
//        JPanel p2 = criarP2();
//        JPanel p3 = criarP3();

        add(p1, BorderLayout.NORTH );
//        add(p2, BorderLayout.CENTER);
//        add(p3, BorderLayout.SOUTH);
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
    
     private JComboBox criarCbEventos(){
        listaEventosOrg =  ATRIBUIR_CONTROLLER.getEventosActivosOrganizador(utilizadorOrganizador);
        ArrayList<String> listaEventosOrgString = new ArrayList();
        for (Evento e : listaEventosOrg){
            listaEventosOrgString.add(e.getTitulo());
        }
        
        String[] arrayListaEventosOrgString = listaEventosOrgString.toArray(new String[0]);
        
        return new JComboBox(arrayListaEventosOrgString);
    }
     
     private JButton criarBtEventos(){
        JButton btn = new JButton("Evento Selecionado");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               for (Evento ev : listaEventosOrg){
                  if (ev.getTitulo().equals(cbEventos.getSelectedItem())) {
                      eventoSelecionado= ev;
                  }
                }
            }
        });
        
        return btn;
     } 
}
