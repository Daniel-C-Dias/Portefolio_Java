/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroeventos.view;

import centroeventos.controller.LoginController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author gonca
 */
public class MenuUI extends JFrame{
    
    private final LoginController LOGIN_CONTROLLER;
    private JLabel textoInformativo;
    private JTextField  email;
    private JTextField  password;
    private int userid;
    
    
    public MenuUI(String titulo) {
        
    super(titulo);
        
        LOGIN_CONTROLLER= new LoginController();
        
        JPanel pHeader = criarPainelHeader();
        JPanel pLogin = criarPainelLogin();
        JPanel pMenu = criarPanielBotoes();

        add(pHeader, BorderLayout.NORTH);
        add(pLogin, BorderLayout.CENTER);
        add(pMenu, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setVisible(true);
    }
    
     
     private JPanel criarPainelHeader() {
        JLabel labelData= new JLabel("Caro utilizador, inicie sessão!",JLabel.CENTER );
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(labelData);
        return p1;
     }
    
    
    
    private JPanel criarPainelLogin() {
        JPanel plog = new JPanel(new GridLayout(2, 1, 0, 10));
        
        JLabel lblEmail = new JLabel("E-mail", JLabel.RIGHT);
        JLabel lblPass = new JLabel("Password", JLabel.RIGHT);

        final int LARGURA = 10;
        email = new JTextField(LARGURA);
        password = new JTextField(LARGURA);
        JButton btnlogin = criarBotaoLogin();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 40, MARGEM_DIREITA = 40;
        p.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR,
                MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(lblEmail);
        p.add(email);
        p.add(lblPass);
        p.add(password);
        p.add(btnlogin);
        
        plog.add(p);
        
        textoInformativo = new JLabel("Exemplo Mensagem de erro", JLabel.CENTER);
        plog.add(textoInformativo);

        return plog;
    }
    
     private JPanel criarPanielBotoes() {
        JPanel p = new JPanel(new FlowLayout());
//        p.add(criarPainelBotao(criarBotaoAtribuir()));
//        p.add(criarPainelBotao(criarBotaoDecidir()));
//        p.add(criarPainelBotao(criarBotaoRegistar()));
        return p;
    }
    
     private JPanel criarPainelBotao(JButton b) {
        JPanel p = new JPanel();
        ((FlowLayout)p.getLayout()).setAlignment(FlowLayout.CENTER);
        p.add(b);
        return p;
    }
    
    
    private JButton criarBotaoLogin() {
       JButton btn = new JButton("Login");
       btn.setToolTipText("Clique para se autenticar");
       btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               
               if(LOGIN_CONTROLLER.fazerLogin(email.getText(), password.getText())){
                   
                   textoInformativo.setBackground(Color.green);
                   textoInformativo.setText("Bem-vindo" + LOGIN_CONTROLLER.getUserName() );
               }
               else{
                   textoInformativo.setBackground(Color.red);
                   textoInformativo.setText("E-mail ou Password errados");
               }
           }
       });
       
       return btn;
    }
    
    private JButton criarBotaoAtribuir() {
      JButton btn = new JButton("Atribuir Candidaturas");
       btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              
           }
       });
       
       return btn;
    }
}
