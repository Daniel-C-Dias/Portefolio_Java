
package centroeventos.model;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class AtribuicaoCandidatura {
    
    private int idAtribuicao;
    private FAE fae;
    private int idCandidatura;
    private DecisaoCandidatura decisao;
    private static int contadorId =1;
    
    public AtribuicaoCandidatura(){
        decisao = new DecisaoCandidatura();
        idAtribuicao=contadorId++;
    }
   
    public AtribuicaoCandidatura(FAE fae,int idCandidatura ){
        this.fae=fae;
        this.idCandidatura=idCandidatura;
        decisao = new DecisaoCandidatura();
        idAtribuicao=contadorId;
        contadorId++;
    }
    
    /**
     * @return the idAtribuicao
     */
    public int getIdAtribuicao() {
        return idAtribuicao;
    }

    /**
     * @return the fae
     */
    public FAE getFae() {
        return fae;
    }

    /**
     * @return the idCandidatura
     */
    public int getIdCandidatura() {
        return idCandidatura;
    }

    /**
     * @return the decisao
     */
    public DecisaoCandidatura getDecisao() {
        return decisao;
    }

    /**
     * @param idAtribuicao the idAtribuicao to set
     */
    public void setIdAtribuicao(int idAtribuicao) {
        this.idAtribuicao = idAtribuicao;
    }

    /**
     * @param fae the fae to set
     */
    public void setFae(FAE fae) {
        this.fae = fae;
    }

    /**
     * @param idCandidatura the idCandidatura to set
     */
    public void setIdCandidatura(int idCandidatura) {
        this.idCandidatura = idCandidatura;
    }

    /**
     * @param decisao the decisao to set
     */
    public void setDecisao(DecisaoCandidatura decisao) {
        this.decisao = decisao;
    }
    
    @Override
    public String toString(){
        return String.format("Id %d ", idCandidatura);
    }    
}
