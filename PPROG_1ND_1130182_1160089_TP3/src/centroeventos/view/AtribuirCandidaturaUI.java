/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroeventos.view;

import centroeventos.controller.AtribuirCandidaturaController;
import centroeventos.model.AlgoritmoAtribuicao;
import centroeventos.model.Candidatura;
import centroeventos.model.Evento;
import centroeventos.model.FAE;
import centroeventos.model.Utilizador;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class AtribuirCandidaturaUI extends JPanel {

    private Utilizador utilizadorOrganizador;
    private final JPanel pCardLayout;
    private final CardLayout cardLayout;
    private List<Evento> listaEventosOrg;
    private List<AlgoritmoAtribuicao> listaAlgoritmos;
    private List<Pair<Candidatura, FAE>> listaCanFae;
    private final AtribuirCandidaturaController ATRIBUIR_CONTROLLER;
    private JComboBox cbEventos;
    private JComboBox cbAlgoritmos;
    private JButton btRegistar;
    private Evento eventoSelecionado;
    private AlgoritmoAtribuicao algoritmoSelecionado;

    public AtribuirCandidaturaUI(Utilizador userContexto, JPanel pCardLayout, CardLayout cardLayout) {

        ATRIBUIR_CONTROLLER = new AtribuirCandidaturaController();
        utilizadorOrganizador = userContexto;
        this.pCardLayout = pCardLayout;
        this.cardLayout = cardLayout;

        setLayout(new BorderLayout(10, 10));

        JPanel p1 = criarP1();
        JPanel p2 = criarP2();
        JPanel p3 = criarP3();

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
    }

    private JPanel criarP1() {
        JPanel p = new JPanel();

        JLabel labelEv = new JLabel("Por favor selecione um evento:", JLabel.CENTER);
        cbEventos = criarCbEventos();
        cbEventos.setMaximumRowCount(4);
        
        p.add(labelEv);
        p.add(cbEventos);
        return p;
    }

    private JPanel criarP2() {
        JPanel pCentro = new JPanel(new BorderLayout(10, 10));
        JPanel p = new JPanel();
        JPanel p1 = new JPanel();

        JLabel labelAlg = new JLabel("Por favor selecione um algoritmo:", JLabel.CENTER);
        cbAlgoritmos = criarCbAlgoritmos();
        cbAlgoritmos.setMaximumRowCount(3);
        JButton btSimular = criarBtSimular();

        p.add(labelAlg);
        p.add(cbAlgoritmos);

        p1.add(btSimular, JButton.CENTER);

        pCentro.add(p, BorderLayout.NORTH);
        pCentro.add(p1, BorderLayout.CENTER);

        return pCentro;
    }

    private JPanel criarP3() {
        JPanel p = new JPanel();

        btRegistar = criarBtRegistar();
        JButton btVoltar = criarBtVoltar();
        btRegistar.setEnabled(false);
        p.add(btRegistar);
        p.add(btVoltar);

        return p;
    }

    private JComboBox criarCbEventos() {
        listaEventosOrg = ATRIBUIR_CONTROLLER.getEventosActivosOrganizador(utilizadorOrganizador);
        ArrayList<String> listaEventosOrgString = new ArrayList();
        for (Evento e : listaEventosOrg) {
            listaEventosOrgString.add(e.getTitulo());
        }

        String[] arrayListaEventosOrgString = listaEventosOrgString.toArray(new String[0]);

        return new JComboBox(arrayListaEventosOrgString);
    }

    private JComboBox criarCbAlgoritmos() {
        listaAlgoritmos = ATRIBUIR_CONTROLLER.getListaAlgoritmos(eventoSelecionado);
        ArrayList<String> listaAlgoritmosString = new ArrayList();
        for (AlgoritmoAtribuicao alg : listaAlgoritmos) {
            listaAlgoritmosString.add(alg.getNomeAlgoritmo());
        }

        String[] arrayListaAlgoritmosString = listaAlgoritmosString.toArray(new String[0]);

        return new JComboBox(arrayListaAlgoritmosString);
    }

    private JButton criarBtSimular() {
        JButton btn = new JButton("Simular Atribuição de Candidaturas");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btRegistar.setEnabled(true);
                
                for (Evento ev : listaEventosOrg) {
                    if (ev.getTitulo().equals(cbEventos.getSelectedItem())) {
                        eventoSelecionado = ev;
                    }
                }
                
                for (AlgoritmoAtribuicao alg : listaAlgoritmos) {
                    if (alg.getNomeAlgoritmo().equals(cbAlgoritmos.getSelectedItem())) {
                        algoritmoSelecionado = alg;
                    }
                }
                
                
                try {
                     AlgoritmoAtribuicao instanciaAlg =algoritmoSelecionado.getClass().newInstance();
                     instanciaAlg.setEvento(eventoSelecionado);
                     listaCanFae=instanciaAlg.atribui();
                } catch (InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(AtribuirCandidaturaUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
              JFrame janela= new JFrame();
              new DialogoListaAtribuicoes(janela, listaCanFae);
              
            }
        });

        return btn;
    }
    
    private JButton criarBtRegistar(){
        JButton btn = new JButton("Registar Atribuição");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(ATRIBUIR_CONTROLLER.registarAtribuicoesCandidaturas(eventoSelecionado,listaCanFae)){
                   JFrame janela= new JFrame();
                     JOptionPane.showMessageDialog(
                                janela,
                                "Atribuições efetuadas com Sucesso",
                                "ISEP - Centro de Eventos",
                                JOptionPane.INFORMATION_MESSAGE);
               }
            }
        });
        
        return btn; 
    }
    
    private JButton criarBtVoltar(){
        JButton btn = new JButton("Voltar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               cardLayout.first(pCardLayout);
            }
        });
        
        return btn; 
    }
}
