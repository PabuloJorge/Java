/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_05;

import java.util.LinkedList;

/**
 *
 * @author pablo
 */
public class Fila_linkedlist {

    private LinkedList<Integer> elemento = new LinkedList<Integer>();
    private int max;

    public Fila_linkedlist() {
        max = 10;
    }

    public Fila_linkedlist(int max) {
        this.max = max;
    }

    public void entraFila(int e) {
        if (!overflow()) {
            elemento.addLast(e);
        } else {
            System.out.println("Fila cheia!");
        }
    }

    public int saiFila() {

        if (!underflow()) {
            return elemento.removeFirst();
        } else {
            System.out.println("Fila vazia!");
            return 0;

        }
    }

    public int primeiroFila() {
        if (!underflow()) {
            return elemento.getFirst();
        } else {
            System.out.println("Fila vazia!");
            return 0;

        }
    }

    public boolean underflow() {
        return elemento.size() == 0;
    }

    public boolean overflow() {
        return elemento.size() == max;
    }

    // toString implementado para testar
    public String toString() {
        String s = "< ";
        for (int i = 0; i < elemento.size(); i++) {
            s += (elemento.get(i)) + " ";
        }
        s += "<";
        return s;

    }

    public int size() {
        return elemento.size();
    }
}
