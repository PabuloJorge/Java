/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_04;



/**
 *
 * @author pablo
 */
public class Pilha_vetor {

    private int[] info;
    private int livre, max;

    // atributos
    public Pilha_vetor() {
        max = 100;
        info = new int[100];
        livre = 0;

    }

    public Pilha_vetor(int t) {
        max = t;
        info = new int[t];
        livre = 0;

    }

    public int size() {
        return livre;
    }

    public void push(int e) {
        if (livre < max) {
            info[livre] = e;
            livre++;
        } else {
            System.out.println("Pilha cheia!!!");
        }

    }

    public int pop() {
        if (livre != 0) {
            livre--;
            return info[livre];
        } else {
            System.out.println("Lista vazia !!!");
            return 0;

        }
    }

    public int top() {
        if (livre != 0) {
            return info[livre - 1];
        } else {
            System.out.println("Lista vazia !!!");
            return 0;
        }
    }

    public boolean underflow() {
        return livre == 0;
    }

    public boolean overflow() {
        return livre == max;
    }

    // exibe implementado para teste

    public void exibe() {
        String s = " ";
        for (int i = 0; i < livre; i++) {
            s += "[" + info[i] + "]  ";

        }
        System.out.println(s);
    }

}
