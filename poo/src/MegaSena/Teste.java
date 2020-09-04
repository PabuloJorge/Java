/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MegaSena;

/**
 *
 * @author pablo
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MegaSena m = new MegaSena(40,41);
        int [] vetor = m.sorteioDeValores(50);
        for (int i =0; i<vetor.length;i++){
            System.out.println(vetor[i]);
        }
        
    }
    
}
