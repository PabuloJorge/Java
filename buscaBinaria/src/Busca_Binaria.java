/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class Busca_Binaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        String[][] dic = {{"cachorro", "dog"}, {"gato", "cat"}, {"água", "water"}, {"preto", "black"},
        {"ola", "hello"}, {"rosa", "pink"}, {"amarelo", "yellow"}, {"vermelho", "red"}, {"passaro", "bird"}};

        int opcao = 0;
        do {
            System.out.println("Escolha em qual idioma quer organizar: ");
            System.out.println("0 - Português");
            System.out.println("1 - Inglês");
            opcao = leia.nextInt();
            if (opcao == 0 || opcao == 1) {
                selectionSort(dic, opcao);
            } else {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 0 && opcao != 1);
        System.out.println("Digite a palvra:");
        leia.nextLine();
        String palavra = leia.nextLine();
        buscaBinaria(dic, palavra, opcao);
        System.out.println(buscaBinaria(dic, palavra, opcao));
    }

    public static String buscaBinaria(String vetor[][], String x, int opcao) {
        Collator collator = Collator.getInstance(new Locale("pt", "BR"));
        collator.setStrength(Collator.PRIMARY);
        int meio;
        int inicio, fim;
        inicio = 0;
        fim = vetor.length - 1;
        int opcao2 = 0;
        if (opcao == 0) {
            opcao2 = 1;
        } else {
            opcao2 = 0;
        }

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (collator.compare(x, vetor[meio][opcao]) < 0) {
                fim = meio - 1;
            } else if (collator.compare(x, vetor[meio][opcao]) > 0) {
                inicio = meio + 1;
            } else {
                return vetor[meio][opcao] + " → " + vetor[meio][opcao2];
            }

        }
        return null;
    }

    public static void selectionSort(String[][] vetor, int opcao) {
        Collator collator = Collator.getInstance(new Locale("pt", "BR"));
        collator.setStrength(Collator.PRIMARY);

        int out, in, min;
        String temp;
        int opcao2;
        if (opcao == 0) {
            opcao2 = 1;
        } else {
            opcao2 = 0;
        }

        for (out = 0; out < vetor.length - 1; out++) { // loop externo
            min = out; // minimo 
            for (in = out + 1; in < vetor.length; in++) // loop interno
            {
                if (collator.compare(vetor[in][opcao], vetor[min][opcao]) < 0) // se min é maior,
                {
                    min = in; // temos um novo mínimo
                }// Coloca o novo mínimo no seu lugar correto no vetor

            }
            temp = vetor[out][opcao];
            vetor[out][opcao] = vetor[min][opcao];
            vetor[min][opcao] = temp;
            temp = vetor[out][opcao2];
            vetor[out][opcao2] = vetor[min][opcao2];
            vetor[min][opcao2] = temp;

        } // fim do laço externo

    }
}
