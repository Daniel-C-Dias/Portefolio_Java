
package Utilitarios;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class IdInvalidoException extends IllegalArgumentException {
     
    public IdInvalidoException() {
        super("Id é inválido!!");
    }
    
    public IdInvalidoException(String mensagem) {
        super(mensagem);
    }
}
