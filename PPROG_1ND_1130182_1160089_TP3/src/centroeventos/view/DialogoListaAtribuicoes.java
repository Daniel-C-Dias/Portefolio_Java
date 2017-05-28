
package centroeventos.view;

import centroeventos.model.Candidatura;
import centroeventos.model.FAE;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javafx.util.Pair;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class DialogoListaAtribuicoes extends JDialog {
 
 private JFrame framePai;
 private List<Pair<Candidatura, FAE>> listaCanFae;
         
         
    public DialogoListaAtribuicoes( JFrame framePai, List<Pair<Candidatura, FAE>> listaCanFae ) {

        super(framePai, "Lista de atribuições geradas pelo algoritmo selecionado", true);

        this.framePai = framePai;
        this.listaCanFae=listaCanFae;
        
        JPanel pPrincipal =criarComponentes();
        add(pPrincipal);
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }
    
    private JPanel criarComponentes(){
        JPanel p = new JPanel(new BorderLayout(20,20));
        JPanel p1 = new JPanel(new GridLayout(listaCanFae.size(),1));
        for(Pair<Candidatura, FAE> par : listaCanFae ){
            JLabel lblAtribuicao = new JLabel(String.format("Candidatura com o id: %d atribuída a FAE: %s", 
                                                            par.getKey().getIdCandidatura(), 
                                                            par.getValue().getuFae().getNome() ));
            p1.add(lblAtribuicao, JLabel.CENTER);
        }
               
        JPanel p2 = new JPanel();
        JButton btnOK = criarBotaoOK();
        p2.add(btnOK, JButton.CENTER);
        p.add(p1, BorderLayout.CENTER);
        p.add(p2, BorderLayout.SOUTH);
        
        return p;
    }
    
      
    
    private JButton criarBotaoOK() {
        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return btn;
    }
}
