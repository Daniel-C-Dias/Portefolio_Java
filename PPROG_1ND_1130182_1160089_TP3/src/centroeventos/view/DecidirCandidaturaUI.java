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
import javax.swing.JRadioButton;

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
    private List <AtribuicaoCandidatura> listaAtribCandidaturasEv;
    private List<Evento> listaEventosFae;
    private final JPanel pCardLayout;
    private final CardLayout cardLayout;
    private int idCandidatura;
    
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
        
        JLabel labelEv = new JLabel("Por favor selecione um evento:", JLabel.CENTER);
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
        
        JLabel labelCan = new JLabel("Por favor selecione uma candidatura:", JLabel.CENTER);
        cbCandidaturas = criarCbCandidaturas();
        cbCandidaturas.setMaximumRowCount(4);
        JButton btCandidatura = criarBtCandidatura();
        
        p.add(labelCan);
        p.add(cbEventos);
        p.add(btCandidatura);
        
        return p;
    }
    
    private JPanel criarP3(){
        JPanel p = new JPanel(new BorderLayout());
        
        JPanel p1 = criarLabel();
        JPanel p2 = criarPainelAceitar();
        
       
        
        p.add(p1, BorderLayout.NORTH);
        p.add(p2, BorderLayout.CENTER);
       
        
        return p;
    }
    
    private JPanel criarLabel(){
        JPanel p = new JPanel();
        
        String motivo=(DECIDIR_CONTROLLER.getMotivoCandidatura(eventoSelecionado,idCandidatura)==null)
        ?"Sem motivo apresentado"
        :DECIDIR_CONTROLLER.getMotivoCandidatura(eventoSelecionado,idCandidatura);
                
        JLabel labelCan = new JLabel(motivo, JLabel.CENTER);
        p.add(labelCan);
        
        return p;
    }
    
    private JPanel criarPainelAceitar(){
        JPanel p = new JPanel();
                
        JLabel lblAceitar = new JLabel("Aceita a candidatura:", JLabel.CENTER);
        p.add(lblAceitar);
        
        
        
        return Criar os radioButtons;
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
    
    private JComboBox criarCbCandidaturas(){ 
        listaAtribCandidaturasEv = DECIDIR_CONTROLLER.getListaCandidaturasFAE(userContexto, eventoSelecionado.getIdEvento());
        ArrayList<Integer> listaIdsCandidaturas = new ArrayList();
        for (AtribuicaoCandidatura atribuicao :listaAtribCandidaturasEv ){
            listaIdsCandidaturas.add(atribuicao.getIdCandidatura());
        }
        
        Integer[] arrayListaCandidaturasEv = listaIdsCandidaturas.toArray(new Integer[0]);
        
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
               p2.revalidate(); 
            }
        });
        
        return btn;
    }
   
    private JButton criarBtCandidatura(){
        JButton btn = new JButton("Candidatura Selecionada");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idCandidatura = Integer.parseInt((String)cbCandidaturas.getSelectedItem());
                for (AtribuicaoCandidatura atribuicao :listaAtribCandidaturasEv ){
                    if(atribuicao.getIdCandidatura()==idCandidatura){
                        candidaturaSelecionada=atribuicao;
                        break;
                    }
                }
                
               p3= criarP3();
               p3.revalidate(); 
            }
        });
        
        return btn;
    }
    
    
 
    //
    
    
//     private  JRadioButton criarRadioBtn(String nome){
//         
//         JRadioButton jbtn = new JRadioButton(nome);
//       
//         jbtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//              ///
//            }
//        });
//         
//        return jbtn;
//     }
    
//      JRadioButton	smallButton= criarRadioBtn("Small");	
//         JRadioButton	mediumButton= criarRadioBtn("Medium");	
//         JRadioButton	largeButton= criarRadioBtn("Large");
//         smallButton.setSelected(true);
//         ButtonGroup	group	= new	ButtonGroup();	
//         group.add(smallButton);	
//         group.add(mediumButton);	
//         group.add(largeButton);
//    p.setBorder(new	TitledBorder(new EtchedBorder(),"Selecione um algoritmo de atribuição"));
}
