package centroeventos.model;

import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public interface AlgoritmoAtribuicao {

    public List<Pair<Candidatura, FAE>> atribui();
    public String getNomeAlgoritmo();
}
