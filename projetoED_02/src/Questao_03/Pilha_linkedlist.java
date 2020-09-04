/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_03;

import java.util.LinkedList;

/**
 *
 * @author pablo
 */
public class Pilha_linkedlist {

    private LinkedList<Character> info = new LinkedList<Character>();
    private int max;

    public Pilha_linkedlist() {
        max = 10;
    }

    public Pilha_linkedlist(int max) {
        this.max = max;
    }

    public int size() {
        return info.size();
    }

    public void push(char e) {

        if (!overflow()) {
            info.addLast(e);
        } else {
            System.out.println("Pilha cheia!");
        }
    }

    public char pop() {

        if (!underflow()) {
            return info.removeLast();
        } else {
            System.out.println("Fila vazia!");
            return 0;

        }
    }

    public char top() {

        if (!underflow()) {
            return info.getLast();
        } else {
            System.out.println("Fila vazia!");
            return 0;

        }
    }

    public boolean underflow() {
        return info.size() == 0;
    }

    public boolean overflow() {
        return info.size() == max;
    }

    // toString implementado para testar
    public String toString() {
        return info.toString();
    }

}
