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
public class Fila_vetor {

    int f[];
    int ini, livre, max, qtd_elem;

    public Fila_vetor(int max) {
        f = new int[max];
        ini = 0;
        this.max = max;
        livre = 0;
    }

    public void entraFila(int v) {
        if (livre < max) {
            f[livre] = v;
            livre++;
            qtd_elem++;
        } else {
            System.out.println("Lista cheia!!!");
        }
    }

    public int saiFila() {
        int ini = f[0];
        if (livre != 0) {
            for (int i = 0; i < livre; i++) {
                f[i] = f[i + 1];
            }
            livre--;
            return ini;
        } else {
            System.out.println("Lista vazia !!!");
            return 0;
        }
    }

    public int primeiroFila() {
        if (livre != 0) {
            return f[0];
        } else {
            System.out.println("Lista vazia !!!");
            return 0;
        }
    }

    public boolean underflow() {
        return qtd_elem == 0;
    }

    public boolean overflow() {
        return qtd_elem == max;
    }

    public void Exibe() {
        System.out.println(this);
    }

    public String toString() {
        String s = "< ";
        for (int i = 0; i < livre; i++) {
            s += (f[i]) + " ";
        }
        s += "<";
        return s;

    }

    
}
