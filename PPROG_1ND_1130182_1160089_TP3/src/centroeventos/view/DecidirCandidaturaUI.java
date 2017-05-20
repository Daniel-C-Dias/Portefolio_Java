/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroeventos.view;

import centroeventos.model.Utilizador;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class DecidirCandidaturaUI extends JPanel {
    
    private Utilizador userContexto;
    
    public DecidirCandidaturaUI(Utilizador userContexto){
       
       this.userContexto=userContexto; 
       this.setLayout(new GridLayout(3,1,10,10));
       JPanel p1= criarP1();
       JPanel p2= criarP2();
       JPanel p3= criarP3();
       
       add(p1);
       add(p2);
       add(p3);
       
    }
    
    private JPanel criarP1(){
        JPanel p = new JPanel();
        
        JLabel labelEv = new JLabel("Por favor selecione um evento!", JLabel.CENTER);
        
        p.add(labelEv);
        return p;
    }
    
    
    
}
