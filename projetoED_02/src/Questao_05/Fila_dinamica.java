
package Questao_05;


public class Fila_dinamica {

    public No ini, fim;
    public int qtd_elem, max;

    public Fila_dinamica() {
        ini = null;
        fim = null;
        qtd_elem = 0;
        max = 10;
    }

    public Fila_dinamica(int valor) {
        ini = null;
        fim = null;
        qtd_elem = 0;
        max = valor;
    }

    public void entraFila(int e) {
        if (qtd_elem == 0) {
            ini = new No(e);
            fim = ini;
            qtd_elem++;
        } else {
            No novo = new No(e);
            fim.prox = novo;
            qtd_elem++;
            fim = novo;
        }

    }

    public int saiFila() {
        if (size() != 0) {
            int v = ini.info;
            ini = ini.prox;
            qtd_elem--;
            return v;
        } else {
            System.out.println("Lista vazia!");
            return 0;
        }
    }

    public int primeiroFila() {
        if (qtd_elem != 0) {
            return ini.info;
        } else {
            System.out.println("Lista vazia!");
            return 0;
        }
    }

    public boolean underflow() {
        return qtd_elem == 0;
    }

    public boolean overflow() {
        return qtd_elem == max;
    }

    
    public String toString() {
        String s = "< ";
        No aux = ini;
        for (int i = 0; i < qtd_elem; i++) {
            s += aux.info + " ";
            aux = aux.prox;

        }
        s += "<";
        return s;

    }

    public int size() {
        return qtd_elem;
    }
}


