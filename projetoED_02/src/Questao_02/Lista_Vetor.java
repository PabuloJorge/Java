package Questao_02;

public class Lista_Vetor {
	
	private double[] vet;
    private int livre, max;

    public Lista_Vetor() {
        max = 1000;
        vet = new double[1000];
        livre = 0;
    }

    public Lista_Vetor(int max) {
        this.max = max;
        vet = new double[max];
        livre = 0;
    }

    public void addLast(double v) {
// implementar
        if (livre < max) {
            vet[livre] = v;
            livre++;
        } else {
            System.out.println("Lista cheia!!!");
        }
    }

    public double getLast() {
        if (livre != 0) {
            return vet[livre - 1];
        } else {
            System.out.println("Lista vazia !!!");
            return 0;
        }
    }

    public double getFirst() {
        if (livre != 0) {
            return vet[0];
        } else {
            System.out.println("Lista vazia !!!");
            return 0;
        }
    }

    public double removeLast() {
        if (livre != 0) {
            livre--;
            return vet[livre];
        } else {
            System.out.println("Lista vazia !!!");
            return 0;

        }
    }

    public double removeFirst() {
        double ini = vet[0];
        if (livre != 0) {
            for (int i = 0; i < livre; i++) {
                vet[i] = vet[i + 1];
            }
            livre--;
            return ini;
        } else {
            System.out.println("Lista vazia !!!");
            return 0;
        }
    }

    public void addFirst(double v) {
        if (livre < max) {

            for (int i = livre; i > 0; i--) {
                vet[i] = vet[i - 1];
            }
            vet[0] = v;
            livre++;
        } else {
            System.out.println("Lista vazia !!!");

        }
    }

    public void add(int i, double v) {
        if (livre < max) {

            for (int j = livre; j > i; j--) {
                vet[j] = vet[j - 1];
            }
            vet[i] = v;
            livre++;
        } else {
            System.out.println("Lista cheia !!!");

        }

    }

    public int size() {
        return livre;
    }

    public void exibe() {
        String s = " ";
        for (int i = 0; i < livre; i++) {
            s += "[" + vet[i] + "]  ";

        }
        System.out.println(s);
    }

 
    public double[] extremos() {
        double vetor[] = new double[2];
        vetor[0] = this.vet[0];
        vetor[1] = this.vet[livre - 1];
        return vetor;

    }

    public double get(int i) {
        // implementar
        if ((i >= 0) && (i < livre)) {
            return vet[i];
        } else {
            System.out.println("Elemento não consta da lista!!!");
            return 0;
        }
    }

    public double remove(int i) {
        double removed = vet[i];
        if (i > 0 && i < livre) {
            for (int j = i; j < livre; j++) {
                vet[j] = vet[j + 1];
            }
            livre--;
            return removed;

        } else {
            System.out.println("Elemento não consta na lista!");
            return 0;
        }
    }

    public double set(int i, double v) {
        double altered = vet[i];
        if (i > 0 && i < livre) {
            vet[i] = v;
            return altered;

        } else {
            System.out.println("Elemento não consta na lista!");
            return 0;
        }
    }

    public double media() {
        double soma = 0, media = 0;
        for (int i = 0; i < livre; i++) {
            soma += vet[i];
        }
        media = soma / size();
        return media;
    }
    
        public String toString() {
        String s = "[ ";
        for (int i = 0; i < livre; i++) {
            s += String.format("%.0f", vet[i]) + " ";
        }
        s += "]";
        return s;
    }
}
