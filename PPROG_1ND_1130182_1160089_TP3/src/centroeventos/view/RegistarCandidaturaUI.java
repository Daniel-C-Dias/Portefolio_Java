
package centroeventos.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import centroeventos.controller.RegistarCandidaturaController;
import centroeventos.model.Evento;
import centroeventos.model.Utilizador;
import java.awt.CardLayout;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistarCandidaturaUI extends JPanel {
   
   private Utilizador utilizadorRepresentante;
   private Utilizador utilizadorParticipante;
   private final RegistarCandidaturaController REGISTAR_CONTROLLER;
   private List<Evento> listaEventos;
   List <Utilizador> listaUtilizadores;
   private JComboBox cbEventos;
   private JComboBox cbParticipantes;
   private Evento eventoSelecionado;
   private JTextField txtMotivo;
   private final JPanel pCardLayout;
   private final CardLayout cardLayout;
   
   public RegistarCandidaturaUI(Utilizador userContexto, JPanel pCardLayout, CardLayout cardLayout){
       
       utilizadorRepresentante=userContexto;
       this.pCardLayout=pCardLayout;
       this.cardLayout=cardLayout;
       REGISTAR_CONTROLLER= new RegistarCandidaturaController();
       setLayout(new GridLayout(4,1));
       
       JPanel p1= criarP1(); 
       JPanel p2= criarP2(); 
       JPanel p3= criarP3();
       JPanel p4= criarP4();
              
       add(p1);
       add(p2);
       add(p3);
       add(p4);
   }
   
   private JPanel criarP1(){
        JPanel p = new JPanel();
        
        JLabel labelEv = new JLabel("Por favor selecione o evento:", JLabel.CENTER);
        cbEventos = criarCbEventos();
        cbEventos.setMaximumRowCount(4);
        
        p.add(labelEv);
        p.add(cbEventos);
        
        return p;
    }
    
    private JPanel criarP2(){
        JPanel p = new JPanel();
        
        JLabel labelPar = new JLabel("Por favor selecione o participante:", JLabel.CENTER);
        cbParticipantes = criarCbParticipantes();
        cbParticipantes.setMaximumRowCount(4);
        
        p.add(labelPar);
        p.add(cbParticipantes);
        
        return p;
    }
    
     private JPanel criarP3(){
        JPanel p = new JPanel(new GridLayout(2,1));
        JPanel p1 = new JPanel();
         
        JLabel labelMotivo = new JLabel("Motivo da Candidatura:", JLabel.CENTER);
        txtMotivo = new JTextField(50);
        p1.add(txtMotivo);
        p.add(labelMotivo);
        p.add(p1);
        
        return p;
     }
    
    private JPanel criarP4(){
        JPanel p = new JPanel();
        
        JButton btConfirmar = criarBtConfirmar();
        JButton btVoltar = criarBtVoltar();
        
        p.add(btConfirmar);
        p.add(btVoltar);
        
        return p;
    }
   
   private JComboBox criarCbEventos(){
        listaEventos =  REGISTAR_CONTROLLER.getEventosActivos();

        ArrayList<String> listaEventosString = new ArrayList();
        for (Evento e : listaEventos){
            listaEventosString.add(e.getTitulo());
        }
        
        String[] arrayListaEventosString = listaEventosString.toArray(new String[0]);
        
        return new JComboBox(arrayListaEventosString);
    }
   
   private JComboBox criarCbParticipantes(){
        listaUtilizadores =  REGISTAR_CONTROLLER.getListaUtilizadores();
        //listaUtilizadores.remove(utilizadorRepresentante); O representante pode ser o participante da própria candidatura
        
        ArrayList<String> listaUtilizadoresString = new ArrayList();
        for (Utilizador u : listaUtilizadores){
            listaUtilizadoresString.add(u.getUserName());
        }
        
        String[] arraylistaUtilizadoresString = listaUtilizadoresString.toArray(new String[0]);
        
        return new JComboBox(arraylistaUtilizadoresString);
    }
   
   
     private JButton criarBtConfirmar(){
        JButton btn = new JButton("Confirmar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Evento ev : listaEventos){
                  if (ev.getTitulo().equals(cbEventos.getSelectedItem())) {
                      eventoSelecionado= ev;
                  }
                }
                
                for (Utilizador u : listaUtilizadores){
                  if (u.getUserName().equals(cbParticipantes.getSelectedItem())) {
                      utilizadorParticipante= u;
                  }
                }
                
                String motivo;
                motivo= txtMotivo.getText().trim().isEmpty() ? "Não preenchido" : txtMotivo.getText().trim();
                boolean registado=REGISTAR_CONTROLLER.registarCandidatura(eventoSelecionado, utilizadorParticipante, utilizadorRepresentante, motivo );
                if(registado){
                    JFrame janela= new JFrame();
                     JOptionPane.showMessageDialog(
                                janela,
                                "Candidatura efetuada com Sucesso",
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
