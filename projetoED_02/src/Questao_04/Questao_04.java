/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_04;

import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class Questao_04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leia = new Scanner(System.in);

        Pilha_vetor p = new Pilha_vetor();
        String frase = "";
        int cont = 0;
        System.out.println("Digite a expressão:");
        // (a+b) - (c+d)
        frase = leia.nextLine();
        for (int i = 0; i < frase.length(); i++) {
            char s = frase.charAt(i);
            char v = '(';
            if (s == v) {
                p.push('(');
            }
        }

        for (int i = 0; i < frase.length(); i++) {
            char s = frase.charAt(i);
            char v = ')';
            if (s == v) {
                if (!p.underflow()) {
                    p.pop();
                } else {
                    cont++;
                }
            }
        }

        System.out.println("Ficou faltando " + cont + " \"(\"");
        System.out.println("Ficou faltando " + p.size() + " \")\"");

    }

}
