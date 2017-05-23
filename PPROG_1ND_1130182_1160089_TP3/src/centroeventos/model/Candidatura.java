
package centroeventos.model;

import Utilitarios.IdInvalidoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class Candidatura implements Serializable {
  
  private int idCandidatura;
  private Representante representante;
  private Participante participante;
  private static int contaCandidaturas = 1;
  private String moradaEmpresaParticipante;

    public Candidatura() {
        this.idCandidatura = contaCandidaturas;
        contaCandidaturas++;
    }
  
  
  public Candidatura(Representante representante, Participante participante, String moradaEmpresaParticipante) {
        this.idCandidatura = contaCandidaturas;
        this.representante = representante;
        this.participante = participante;
        this.moradaEmpresaParticipante=moradaEmpresaParticipante;
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
    
       /**
     * @return the moradaEmpresaParticipante
     */
    public String getMoradaEmpresaParticipante() {
        return moradaEmpresaParticipante;
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
    
    /**
     * @param moradaEmpresaParticipante the moradaEmpresaParticipante to set
     */
    public void setMoradaEmpresaParticipante(String moradaEmpresaParticipante) {
        this.moradaEmpresaParticipante = moradaEmpresaParticipante;
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
