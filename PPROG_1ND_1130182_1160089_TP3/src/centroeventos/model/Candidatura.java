
package centroeventos.model;

import Utilitarios.IdInvalidoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class Candidatura {
  
  private int idCandidatura;
  private Representante representante;
  private Participante participante;
  private int contaCandidaturas;

    public Candidatura() {
        contaCandidaturas++;
    }
  
  
  public Candidatura(int idCandidatura, Representante representante, Participante participante) {
        this.idCandidatura = idCandidatura;
        this.representante = representante;
        this.participante = participante;
        contaCandidaturas++;
    }

    public int getIdCandidatura() {
        return idCandidatura;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setIdCandidatura(int idCandidatura) {
        this.idCandidatura = idCandidatura;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }
  
  
  
  public boolean valida() {
        if (idCandidatura < 1) {
            throw new IdInvalidoException("ID " + idCandidatura + " é inválido!!");
        }
        else if(representante.equals(null)){
            throw new NullPointerException("Representante " + idCandidatura + " é inválido!!");
        }
        else if(participante.equals(null)){
            throw new NullPointerException("Representante " + idCandidatura + " é inválido!!");
        }
        else {
        return true;
        }
    }
   
}
