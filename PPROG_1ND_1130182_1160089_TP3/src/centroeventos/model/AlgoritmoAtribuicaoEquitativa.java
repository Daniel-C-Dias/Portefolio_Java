package centroeventos.model;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class AlgoritmoAtribuicaoEquitativa implements AlgoritmoAtribuicao {

    private static RegistoCandidaturas registoCandidaturas = RegistoCandidaturas.getInstance();
    private static RegistoFAE registoFAE = RegistoFAE.getInstance();

    @Override
    public List<AtribuicaoCandidatura> atribui() {
        List<FAE> listaFae = registoFAE.getListaFAE();
        List<Candidatura> listaCandidatura = registoCandidaturas.getListaCandidaturas();
        List<AtribuicaoCandidatura> listaAtribuicoes = new ArrayList();
        int quantosFAE = listaFae.size() / listaCandidatura.size(); //numero total de Fae a atribuir por candidatura
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
