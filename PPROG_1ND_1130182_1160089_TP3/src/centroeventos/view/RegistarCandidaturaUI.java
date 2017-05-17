
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

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class RegistarCandidaturaUI extends JFrame {
     
    private JTextField txfData = new JTextField(6);
    private JTextField txfDiaSemana = new JTextField(10);
    private JLabel lbDataExtenso = new JLabel();
    
    public RegistarCandidaturaUI() {
        
        super("Registar Candidatura");
        
        criarComponentes();
        
        setDefaultCloseOperation((EXIT_ON_CLOSE));
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setVisible(true);
        
    }

    private void criarComponentes() {
        JPanel p = new JPanel(new GridLayout(4, 1, 0, 10));
        
        p.add(criarPainelData(txfData));
        p.add(criarPainelDiaSemana(txfDiaSemana));
        p.add(criarPainelDataExtenso(lbDataExtenso));
        p.add(criarPanielBotoes());
        
        add(p);
    }

    
    private JPanel criarPanielBotoes() {
        JPanel p = new JPanel();
        p.add(criarBotaoDiaSemana());
        p.add(criarBotaoDataExtenso());
        p.add(criarBotaoLimpar());
        return p;
    }

    private JPanel criarPainelData(JTextField txfData) {
        
        JPanel p = new JPanel();
        p.add(new JLabel("Data(aaaa/mm/dd): "));
        p.add(txfData);
        return p;
    }

    private JPanel criarPainelDiaSemana(JTextField txfDiaSemana) {
        JPanel p = new JPanel();
        p.add(new JLabel("Dia da Semana: "));
        
        txfDiaSemana.setEnabled(false);
        p.add(txfDiaSemana);
        
        return p;
    }

    private JPanel criarPainelDataExtenso(JLabel lbDataExtenso) {
        JPanel p = new JPanel();
        p.add(lbDataExtenso);
        return p;
    }

    private JButton criarBotaoDiaSemana() {
        JButton btn = new JButton("Dia da Semana");
       btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              if(extrairData(txfData.getText()) != null) { 
                  txfDiaSemana.setText(extrairData(txfData.getText()).diaDaSemana()); 
              }
              
           }
       });
       
       return btn;
    }

    private JButton criarBotaoDataExtenso() {
        JButton btn = new JButton("Data por Extenso");
       btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              
              if(extrairData(txfData.getText()) != null) {lbDataExtenso.setText(extrairData(txfData.getText()).toString());}
            
              
           }
       });
       
       return btn;
    }

    private JButton criarBotaoLimpar() {
      JButton btn = new JButton("Limpar");
       btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              lbDataExtenso.setText(null);
              txfData.setText(null);
              txfDiaSemana.setText(null);
           }
       });
       
       return btn;
    }
    
    private Data extrairData(String texto){
        
        try {
        String[] partesData = texto.split("/");
               int ano = Integer.parseInt(partesData[0]);
               int mes = Integer.parseInt(partesData[1]);
               int dia = Integer.parseInt(partesData[2]);
                  
               Data d = new Data(ano,mes,dia);
               
               return d;
                         
        }
        catch(DiaInvalidoException | MesInvalidoException e ){     
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Data Inválida!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
       
     
        return null;
    }

}
