
package centroeventos.view;

import centroeventos.controller.LoginController;
import centroeventos.model.Utilizador;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class MenuUI extends JFrame {

    private final LoginController LOGIN_CONTROLLER;
    private final CardLayout cardLayout;
    private final JPanel pCardLayout;
    private static final String PAINEL_INICIAL = "Painel Inicial", UC03 = "Atribuir Candidaturas", UC04 = "Decidir Candidatura", UC05 = "Registar Candidatura";
    private JPanel pInicial;
    private JPanel pMenu;
    private JLabel textoInformativo;
    private JTextField email;
    private JPasswordField password;
    private Utilizador userContexto;

    { //inicializing block
        LOGIN_CONTROLLER = new LoginController();
        LOGIN_CONTROLLER.carregarDados();
    }
    
    
    
    public MenuUI(String titulo) {

        super(titulo);

        cardLayout = new CardLayout();
        pCardLayout = criarPainelCardLayout();
       
        add(pCardLayout);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
         addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                terminar("Fechar");
            }
        });
    }

    private JPanel criarPainelCardLayout() {
        JPanel p = new JPanel(cardLayout);
        p.add(criarPainelInicial(), PAINEL_INICIAL);
        return p;
    }
    
    private JPanel criarPainelInicial(){
        JPanel pInicial = new JPanel(new BorderLayout());
        JPanel pHeader = criarPainelHeader();
        JPanel pLogin = criarPainelLogin();
        pMenu = criarPanielBotoes();

       pInicial.add(pHeader, BorderLayout.NORTH);
       pInicial.add(pLogin, BorderLayout.CENTER);
       pInicial.add(pMenu, BorderLayout.SOUTH);
       pMenu.setVisible(false);
        
        return pInicial;
    }
    

    private JPanel criarPainelHeader() {
        JPanel p1 = new JPanel();
        JLabel labelData = new JLabel("Caro utilizador, inicie sessão!", JLabel.CENTER);
        p1.add(labelData);
        return p1;
    }

    private JPanel criarPainelLogin() {
        JPanel plog = new JPanel(new GridLayout(2, 1, 0, 10));

        JLabel lblEmail = new JLabel("E-mail", JLabel.RIGHT);
        JLabel lblPass = new JLabel("Password", JLabel.RIGHT);

        final int LARGURA = 10;
        email = new JTextField(LARGURA);
        password = new JPasswordField(LARGURA);
        JButton btnlogin = criarBotaoLogin();
        JButton btnLimparLogin = criarLimparLogin();

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
        p.add(btnLimparLogin);

        plog.add(p);

        textoInformativo = new JLabel("Projeto: Centro de Eventos", JLabel.CENTER);
        plog.add(textoInformativo);

        return plog;
    }

    private JPanel criarPanielBotoes() {
        JPanel p = new JPanel(new GridLayout(3, 1, 10, 10));
        p.add(criarPainelBotao(criarBotaoAtribuir()));
        p.add(criarPainelBotao(criarBotaoDecidir()));
        p.add(criarPainelBotao(criarBotaoRegistar()));
        return p;
    }

    private JPanel criarPainelBotao(JButton b) {
        JPanel p = new JPanel();
        p.add(b);
        return p;
    }

    private JButton criarBotaoLogin() {
        JButton btn = new JButton("Login");
        btn.setToolTipText("Clique para se autenticar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (LOGIN_CONTROLLER.fazerLogin(email.getText(), password.getPassword())) {
                    textoInformativo.setForeground(Color.green);
                    textoInformativo.setText("Bem-vindo " + LOGIN_CONTROLLER.getUserName());
                    userContexto=LOGIN_CONTROLLER.getUserContexto();
                    pMenu.setVisible(true);
                    pMenu.revalidate();
                    pack();
                    
                } else {
                    textoInformativo.setForeground(Color.red);
                    textoInformativo.setText("E-mail ou Password errados!");
                }
            }
        });

        return btn;
    }

    private JButton criarLimparLogin() {
        JButton btn = new JButton("Limpar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                email.setText(null);
                password.setText(null);
            }
        });

        return btn;
    }

    private JButton criarBotaoAtribuir() {
        JButton btn = new JButton("Atribuir Candidaturas");
        btn.setPreferredSize(new Dimension(200,50));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCardLayout.add(new AtribuirCandidaturaUI(userContexto, pCardLayout,cardLayout), UC03);
                cardLayout.show(pCardLayout, UC03);
            }
        });

        return btn;
        
    }
    
    private JButton criarBotaoDecidir() {
        JButton btn = new JButton("Decidir Candidatura");
        btn.setPreferredSize(new Dimension(200,50));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCardLayout.add(new DecidirCandidaturaUI(userContexto, pCardLayout,cardLayout), UC04);
                cardLayout.show(pCardLayout, UC04);
            }
        });

        return btn;
    }
   
    private JButton criarBotaoRegistar() {
        JButton btn = new JButton("Registar Candidatura");
        btn.setPreferredSize(new Dimension(200,50));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCardLayout.add(new RegistarCandidaturaUI(userContexto, pCardLayout, cardLayout), UC05);
                cardLayout.show(pCardLayout, UC05);
            }
        });

        return btn;
    }
    
     private void terminar(String tituloDialogo) {
        guardarListaEventosUtilizadores(tituloDialogo);
        dispose();
    }
     
    private void guardarListaEventosUtilizadores(String tituloDialogo) {
        boolean listaGuardada = LOGIN_CONTROLLER.guardarBinario();
        if (!listaGuardada) {
            JOptionPane.showMessageDialog( MenuUI.this,
                                           "Impossível guardar listas de utilizadores e eventos!",
                                           tituloDialogo,
                                           JOptionPane.ERROR_MESSAGE);
        }
    }    
    
}
