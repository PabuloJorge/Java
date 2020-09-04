/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pablo
 */
public class TestandoConta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conta c = new Conta (10,100);
        c.Imprimir();
        c.Saque(50);
        c.Imprimir();
        c.Saque(60);
         c.Imprimir();
        
    }
    
}
