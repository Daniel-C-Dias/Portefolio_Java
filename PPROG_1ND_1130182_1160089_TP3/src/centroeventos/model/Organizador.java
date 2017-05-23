
package centroeventos.model;

/**
 *
 * @author Daniel Dias & José Gonçalves
 */
public class Organizador {
    
 private Utilizador uOrganizador;
 private String nome;
  
    public Organizador()
    {
    }

    public Organizador(Utilizador uOrganizador, String nome) {
        this.uOrganizador = uOrganizador;
        this.nome=nome;
    }
    
    
     /**
     * @return the uOrganizador
     */
    public Utilizador getuOrganizador() {
        return uOrganizador;
    }
    
    public void setuOrganizador(Utilizador u)
    {
        this.uOrganizador = u;
    }
   
 
    public boolean valida()
    {
        // Introduzir as validações aqui
        return true;
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        Organizador o = (Organizador) outroObjeto;
        return this.uOrganizador == o.getuOrganizador();
    }
    
    
 
   
 @Override
    public String toString()
    {
        return this.getuOrganizador().toString();
    }

  
}

    

