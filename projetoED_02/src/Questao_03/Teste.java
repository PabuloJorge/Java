/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_03;

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
        Pilha_linkedlist p = new Pilha_linkedlist();
        System.out.println(p.underflow());
        p.push('a');
        p.push('b');
        p.push('c');
        System.out.println(p.overflow());
        System.out.println(p);
        System.out.println(p.pop());
        System.out.println(p.top());
    }
    
}
