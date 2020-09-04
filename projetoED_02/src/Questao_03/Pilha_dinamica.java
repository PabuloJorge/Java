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
public class Pilha_dinamica {

    // atributos
    public No ini;
    public int tam, max;

    public Pilha_dinamica() {
        ini = null;
        tam = 0;
        max = 10;

    }

    public Pilha_dinamica(int t) {
        ini = null;
        tam = 0;
        max = t;

    }

    public int size() {
        return tam;
    }

    public void push(char e) {
        if (tam == 0) {
            ini = new No(e);
            tam++;
        } else if (tam < max) {

            No novo = new No(e);
            novo.prox = ini;
            ini = novo;
            tam++;

        } else {
            System.out.println("Pilha cheia!");
        }
    }

    public char pop() {
        if (size() != 0) {
            char v = (char) ini.info;
            ini = ini.prox;
            tam--;
            return v;
        } else {
            System.out.println("Pilha vazia!");
            return '?';
        }
    }

    public char top() {
        if (tam != 0) {
            return (char) ini.info;
        } else {
            System.out.println("Pilha vazia!");
            return '?';
        }
    }

    public boolean underflow() {
        return tam == 0;
    }

    public boolean overflow() {
        return tam == max;
    }
// implementado apenas para teste

    public void exibe() {
        if (tam != 0) {
            String s = " ";
            No aux = ini;
            for (int i = 0; i < tam; i++) {
                s += "[" + (char) aux.info + "]";
                aux = aux.prox;

            }
            System.out.println(s);
        } else {
            System.out.println("Pilha vazia!");
        }

    }

}
