package Questao_02;

public class Lista_Dinamica {
	

	public class Lista_dinamica {

	    public No ini, fim;
	    public int tam, max;

	    public Lista_dinamica() {
	        ini = null;
	        fim = null;
	        tam = 0;
	        max = 1000;
	    }

	    public Lista_dinamica(int valor) {
	        ini = null;
	        fim = null;
	        tam = 0;
	        max = valor;
	    }

	    public void add(int i, double v) {
	        if (i >= 0 && i <= size()) {
	            if (i == 0) {
	                addFirst(v);
	            } else if (i == size()) {
	                addLast(v);
	            } else {
	                No aux = ini;
	                for (int j = 0; j < i - 1; j++) {
	                    aux = aux.prox;
	                }
	                No novo = new No(v, aux.prox);
	                aux.prox = novo;
	                tam++;
	            }
	        } else {
	            System.out.println("Posição não consta da lista!!!");
	        }
	    }

	    public double removeFirst() {
	        if (size() != 0) {
	            double v = ini.info;
	            // No aux = ini;
	            ini = ini.prox;
	            // free (aux);
	            tam--;
	            return v;
	        } else {
	            System.out.println("Lista vazia!");
	            return 0;
	        }
	    }

	    public double removeLast() {
	        if (size() != 0) {
	            double v = fim.info;
	            No aux = ini;
	            while (aux.prox.prox != null) {
	                aux = aux.prox;
	            }
	            aux.prox = null;
	            // free (fim);
	            fim = aux;
	            tam--;
	            return v;
	        } else {
	            System.out.println("Lista vazia!");
	            return 0;
	        }
	    }

	    public void addLast(double e) {

	        if (tam == 0) {
	            ini = new No(e);
	            fim = ini;
	            tam++;
	        } else {
	            No novo = new No(e);
	            fim.prox = novo;
	            tam++;
	            fim = novo;
	        }
	    }

	    public void addFirst(double e) {

	        if (tam == 0) {
	            ini = new No(e);
	            fim = ini;
	            tam++;
	        } else {

	            No novo = new No(e);
	            novo.prox = ini;
	            ini = novo;
	            tam++;

	        }
	    }

	    public double getLast() {
	        if (tam != 0) {
	            return fim.info;
	        } else {
	            System.out.println("Lista vazia!");
	            return 0;
	        }
	    }

	    public double getFirst() {
	        if (tam != 0) {
	            return ini.info;
	        } else {
	            System.out.println("Lista vazia!");
	            return 0;
	        }
	    }

	    public void exibe() {
	        if (tam != 0) {
	            String s = " ";
	            No aux = ini;
	            for (int i = 0; i < tam; i++) {
	                s += "[" + aux.info + "]";
	                aux = aux.prox;

	            }
	            System.out.println(s);
	        } else {
	            System.out.println("Lista vazia!");
	        }

	    }

	    public int size() {
	        return tam;
	    }

	    public void printSecond() {
	        if (tam >= 2) {
	            No x;
	            x = ini.prox;
	            System.out.println(x.info);
	        } else {
	            System.out.println("Erro!");
	        }
	    }

	    public void inverte() {
	        No anterior = null, proximo = null;
	        No aux = ini;
	        while (aux != null) {
	            proximo = aux.prox;
	            aux.prox = anterior;
	            anterior = aux;
	            aux = proximo;
	        }
	        ini = anterior;
	    }

	    public double get(int i) {
	        if (i < tam) {
	            No aux = ini;
	            for (int j = 0; j < i; j++) {
	                aux = aux.prox;
	            }
	            return aux.info;

	        } else {
	            System.out.println("Elemento não consta na lista!");
	            return 0;
	        }

	    }

	    public double remove(int i) {
	        double removed = 0;
	        if (i >= 0 && i <= size()) {
	            if (i == 0) {
	                return removeFirst();
	            } else if (i == size()) {
	                return removeLast();
	            } else {
	                No aux = ini;
	                for (int j = 0; j < i - 1; j++) {
	                    aux = aux.prox;
	                }
	                removed = aux.prox.info;
	                aux.prox = aux.prox.prox;
	                tam--;
	                return removed;

	            }

	        } else {
	            System.out.println("Posição não consta da lista!!!");
	            return 0;
	        }

	    }

	    public double set(int i, double v) {
	        // implementar
	        if (i < tam) {
	            No aux = ini;
	            double seted = 0;
	            for (int j = 0; j < i; j++) {
	                aux = aux.prox;
	            }
	            seted = aux.info;
	            aux.info = v;
	            return seted;

	        } else {
	            System.out.println("Elemento não consta na lista!");
	            return 0;
	        }
	    }

	    public double media() {
	        if (size() != 0) {
	            double soma = 0, media = 0;
	            No aux = ini;
	            for (int i = 0; i < tam; i++) {
	                soma += aux.info; // soma = soma + aux.info
	                aux = aux.prox;
	            }
	            media = soma / size();
	            return media;

	        } else {
	            System.out.println("Lista vazia!");
	            return 0;
	        }

	    }

	    public String toString() {

	        String s = "[ ";
	        No aux = ini;
	        for (int i = 0; i < tam; i++) {
	            s += String.format("%.0f", aux.info) + " ";
	            aux = aux.prox;

	        }
	        s += "]";
	        return s;

	    }
	    }
	}
	

	/*
	 public void addLast_sem_fim( double e ){
		
	 if ( tam == 0 )
	 {
	 ini = new No(e);
	 tam++;
	 }
	 else
	 {
	 No aux = ini;
	 while ( aux.prox != null ) 
	 aux = aux.prox;
	 No novo = new No(e);
	 aux.prox = novo;
	 tam++;
	 }
	 }
	 */
	/*
	 public int size2()
	 {
		
	 int cont =0;
	 No aux;
	 aux = ini;
	 while (aux != null )
	 {
	 cont ++;
	 aux = aux.prox;
	 }
	 return cont;
	 //	return tam;
	 }
	 */

