
package centroeventos.model;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class DecisaoCandidatura {
    
    private boolean jaAvaliada;
    private boolean aceite; 
    private String justificacaoDecisao;

    /**
     * @return the jaAvaliada
     */
    public boolean isJaAvaliada() {
        return jaAvaliada;
    }

    /**
     * @return the aceite
     */
    public boolean isAceite() {
        return aceite;
    }

    /**
     * @return the justificacaoDecisao
     */
    public String getJustificacaoDecisao() {
        return justificacaoDecisao;
    }

    /**
     * @param jaAvaliada the jaAvaliada to set
     */
    public void setJaAvaliada(boolean jaAvaliada) {
        this.jaAvaliada = jaAvaliada;
    }

    /**
     * @param aceite the aceite to set
     */
    public void setAceite(boolean aceite) {
        this.aceite = aceite;
    }

    /**
     * @param justificacaoDecisao the justificacaoDecisao to set
     */
    public void setJustificacaoDecisao(String justificacaoDecisao) {
        this.justificacaoDecisao = justificacaoDecisao;
    }
    
    
}
