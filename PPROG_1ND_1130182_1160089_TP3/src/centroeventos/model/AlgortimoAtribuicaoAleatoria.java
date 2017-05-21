
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class AlgortimoAtribuicaoAleatoria implements AlgoritmoAtribuicao{

    private static RegistoCandidaturas registoCandidaturas = RegistoCandidaturas.getInstance();
    private static RegistoFAE registoFAE = RegistoFAE.getInstance();
    
    @Override
    public List<AtribuicaoCandidatura> atribui() {
        List<FAE> listaFae = registoFAE.getListaFAE();
        List<Candidatura> listaCandidatura = registoCandidaturas.getListaCandidaturas();
        List<AtribuicaoCandidatura> listaAtribuicoes = new ArrayList();
    
        for(int i = 0; i < listaFae.size() ; i ++){
            listaAtribuicoes.add(new AtribuicaoCandidatura(listaFae.get(i),ThreadLocalRandom.current().nextInt(0, listaCandidatura.size() + 1) ));
        }
        
        return listaAtribuicoes;
        
    }

  
    
}
