
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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class DecidirCandidaturaUI extends JPanel {
    
    private Utilizador userContexto;
    private Evento eventoSelecionado;
    private AtribuicaoCandidatura candidaturaSelecionada;
    private JComboBox cbEventos;
    private JComboBox cbCandidaturas;
    private JButton btDecidir;
    private JPanel p2;
    private JPanel p3;
    private final DecidirCandidaturaController DECIDIR_CONTROLLER;
    private List <AtribuicaoCandidatura> listaAtribCandidaturasEv;
    private List<Evento> listaEventosFae;
    private final JPanel pCardLayout;
    private final CardLayout cardLayout;
    private int idCandidatura;
    private JTextField txtMotivo;
    private ButtonGroup group;
    private JRadioButton btnSim;
    private JRadioButton btnNao;
    
    public DecidirCandidaturaUI(Utilizador userContexto, JPanel pCardLayout, CardLayout cardLayout){
       
       DECIDIR_CONTROLLER= new DecidirCandidaturaController();
       this.userContexto=userContexto; 
       this.pCardLayout=pCardLayout;
       this.cardLayout=cardLayout;
       this.setLayout(new BorderLayout(10,10));
       JPanel p1= criarP1();
       p2= new JPanel();
       p3= new JPanel();
       p2.setVisible(false);
       p3.setVisible(false);
       
       add(p1, BorderLayout.NORTH);
       add(p2, BorderLayout.CENTER);
       add(p3, BorderLayout.SOUTH);
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
        p.add(cbCandidaturas);
        p.add(btCandidatura);
        
        return p;
    }
    
    private JPanel criarP3(){
        JPanel p = new JPanel(new BorderLayout());
        
        JPanel p1 = criarLabel();
        JPanel p2 = criarPainelAceitar();
        JPanel p3 = criarBotoesDecidir();
        
        p.add(p1, BorderLayout.NORTH);
        p.add(p2, BorderLayout.CENTER);
        p.add(p3, BorderLayout.SOUTH);
        
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
        JPanel pPainel = new JPanel(new GridLayout(3,1,10,10));
        
        JPanel p1 = new JPanel();
        JLabel lblAceitar = new JLabel("Aceita a candidatura:", JLabel.CENTER);
        p1.add(lblAceitar);
        
        btnSim = criarRadioBtn("Sim");	
        btnNao= criarRadioBtn("Não");
        btnSim.setSelected(true);
        group = new	ButtonGroup();	
        group.add(btnSim);	
        group.add(btnNao);	
        p1.add(btnSim);
        p1.add(btnNao);
        
        JLabel lblMotivo = new JLabel("Texto justificativo da decisão:", JLabel.CENTER);
        
        txtMotivo = new JTextField();
        
        pPainel.add(p1);
        pPainel.add(lblMotivo);
        pPainel.add(txtMotivo);
        
        return pPainel;
    }
    
    private JPanel criarBotoesDecidir(){
        JPanel p = new JPanel();
        
        btDecidir = criarBtDecidir();
        JButton btVoltar = criarBtVoltar();
        p.add(btDecidir);
        p.add(btVoltar);

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
                      break;
                  }
                }
               p2= criarP2();
               add(p2, BorderLayout.CENTER);
               p2.setVisible(true);
               revalidate();
            }
        });
        
        return btn;
    }
   
    private JButton criarBtCandidatura(){
        JButton btn = new JButton("Candidatura Selecionada");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idCandidatura = (Integer)cbCandidaturas.getSelectedItem() ;
                for (AtribuicaoCandidatura atribuicao :listaAtribCandidaturasEv ){
                    if(atribuicao.getIdCandidatura()==idCandidatura){
                        candidaturaSelecionada=atribuicao;
                        break;
                    }
                }
               p3= criarP3();
               add(p3, BorderLayout.SOUTH);
               p3.setVisible(true);
               revalidate();
            }
        });
        
        return btn;
    }
    
     private  JRadioButton criarRadioBtn(String nome){
         
         JRadioButton jbtn = new JRadioButton(nome);
       
         jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jbtn.setSelected(true);
            }
        });
         
        return jbtn;
    }
     
    private JButton criarBtDecidir(){
        JButton btn = new JButton("Decidir Candidatura");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String motivo;
                motivo= txtMotivo.getText().trim().isEmpty() ? "Não preenchido" : txtMotivo.getText().trim();
                boolean aceita=btnSim.isSelected();
                boolean registado=DECIDIR_CONTROLLER.registarDecisao(eventoSelecionado, candidaturaSelecionada , aceita, motivo);
                if(registado){
                    JFrame janela= new JFrame();
                     JOptionPane.showMessageDialog(
                                janela,
                                "Decisão registada com Sucesso",
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
