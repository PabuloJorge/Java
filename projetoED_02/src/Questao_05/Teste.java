/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_05;

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
        Fila_linkedlist f = new Fila_linkedlist();
        
        f.entraFila(11);
        f.entraFila(12);
        f.entraFila(13);
        f.entraFila(14);
        f.entraFila(15);
        f.entraFila(16);
        f.entraFila(17);
        f.entraFila(18);
        f.entraFila(19);
        f.entraFila(20);
        System.out.println(f);
        System.out.println(f.saiFila());
        System.out.println(f);
        f.entraFila(11);
        System.out.println(f);
        System.out.println(f.primeiroFila());
        
        
        
        
        
        
        
    }
    
}
