
package Controle;

/**
 *
 * @author Rodrigues
 */
public class GeradorPasswordUser {
    
    public String gerarUsername(String nome,String apelido)
    {
        char user=nome.charAt(0);
        String username=user+""+apelido;
        return username;
    }
    
    public String gerarPassword(String apelido,String contacto)
    {
        char pass=apelido.charAt(0); 
        String password=contacto+""+pass;
        return  password;
    }
    
}
