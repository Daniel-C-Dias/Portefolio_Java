
package centroeventos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class AlgoritmoAtribuicaoPorNumero implements AlgoritmoAtribuicao{

    private static RegistoCandidaturas registoCandidaturas = RegistoCandidaturas.getInstance();
    private static RegistoFAE registoFAE = RegistoFAE.getInstance();
    private static int quantosFAE=2; //este atributo vai ter que ir buscar ao UI o numero de  Fae por candidatura que o Organizador deseja
    //caso não seja possivel transmitir o numero de Fae que o Organizador escreva no UI, chama-se a esta classe AlgortimoAtribuicaoPar e ou põe-se Fae 2 a 2 ou index par e impar
    // inventa-se qualquer coisa depois

    @Override
    public List<AtribuicaoCandidatura> atribui() {
        List<FAE> listaFae = registoFAE.getListaFAE();
        List<Candidatura> listaCandidatura = registoCandidaturas.getListaCandidaturas();
        List<AtribuicaoCandidatura> listaAtribuicoes = new ArrayList();
        int n = 0; //contador de ajuda a atribuição

        for (int i = 0; i < listaCandidatura.size(); i++) {
            for (int j = 0; j < listaFae.size(); j++) {
                while (n != quantosFAE) {
                    if (listaAtribuicoes.contains(new AtribuicaoCandidatura(listaFae.get(j), listaCandidatura.get(i).getIdCandidatura()))) {
                        j++;
                    } else {
                        listaAtribuicoes.add(new AtribuicaoCandidatura(listaFae.get(j), listaCandidatura.get(i).getIdCandidatura()));
                    }
                }
            }

        }
            return listaAtribuicoes;
    }
    
}
