
package centroeventos.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import Utilitarios.*;
import centroeventos.controller.RegistarCandidaturaController;
import centroeventos.model.Evento;
import centroeventos.model.Utilizador;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistarCandidaturaUI extends JPanel {
   
   private Utilizador userRepresentante;
   private Utilizador utilizadorParticipante;
   private final RegistarCandidaturaController REGISTAR_CONTROLLER;
   private JPanel p2;
   private List<Evento> listaEventos;
   private JComboBox cbEventos;
   private Evento eventoSelecionado;
   
   public RegistarCandidaturaUI(Utilizador userContexto){
       
       userRepresentante=userContexto;
       REGISTAR_CONTROLLER= new RegistarCandidaturaController();
              
       JPanel p1= criarP1(); // Selecionar Evento
       p2= criarP2(); // Selecionar utilizador participante e respetiva morada Morada para instanciar candidatura
       p3= criarP3(); // Botão Voltar
              
       add(p1, BorderLayout.NORTH);
       add(p2, BorderLayout.CENTER);
       add(p3, BorderLayout.SOUTH);
   }
   
   private JPanel criarP1(){
        JPanel p = new JPanel();
        
        JLabel labelEv = new JLabel("Por favor selecione O evento!", JLabel.CENTER);
        cbEventos = criarCbEventos();
        cbEventos.setMaximumRowCount(4);
        JButton btEventos = criarBtEventos();
        
        p.add(labelEv);
        p.add(cbEventos);
        p.add(btEventos);
        
        return p;
    }
   
   
   private JComboBox criarCbEventos(){
        listaEventos =  REGISTAR_CONTROLLER.getEventosActivos();
        
        ArrayList<String> listaEventosFaeString = new ArrayList();
        for (Evento e : listaEventos){
            listaEventosFaeString.add(e.getTitulo());
        }
        
        String[] arrayListaEventosFaeString = listaEventosFaeString.toArray(new String[0]);
        
        return new JComboBox(arrayListaEventosFaeString);
    }
   
    private JButton criarBtEventos(){
        JButton btn = new JButton("Evento Selecionado");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               for (Evento ev : listaEventos){
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
}
