package Questao_03;

import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;

public class Busca_Binaria {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		String[][] dic = { { "cachorro", "dog" }, { "gato", "cat" }, { "teclado", "keyboard" }, { "rato", "mouse" },
				{ "abacaxi", "pineapple" }, { "faca", "knife" }, { "mar", "sea" }, { "sabonete", "soap" },
				{ "verde", "green" }, { "azul", "blue" }, { "vermelho", "red" }, { "branco", "white" },
				{ "livro", "book" }, { "caneta", "pen" }, { "bicicleta", "bike" }, { "jogo", "game" },
				{ "caixa", "box" }, { "telefone", "phone" }, { "carro", "car" }, { "cadeira", "chair" },
				{ "manual", "manual" }, { "osso", "bone" }, { "outono", "fall" }, { "inverno", "winter" },
				{ "porta", "door" }, { "veleiro", "yacht" }, { "ilha", "island" }, { "zebra", "zebra" },
				{ "zero", "zero" }, { "preto", "black" } };

		int opcao = 0;
		do {

			System.out.println("Escolha a opção de tradução:");
			System.out.println("0 - Português → Inglês");
			System.out.println("1 - Inglês → Português");
			System.out.println("2 - Sair");
			opcao = leia.nextInt();
			if (opcao == 2) {
				break;
			}
			selectionSort(dic, opcao);

			System.out.println("Digite a palvra:");
			leia.nextLine();
			String palavra = leia.nextLine();
			String s = buscaBinaria(dic, palavra, opcao);
			if (s != null) {
				System.out.println(s);
			} else {
				System.out.println("Palavra não encontrada!");
			}
			System.out.println("_______________________________________________");
		} while (opcao != 2);
		System.out.println("Programa Finalizado!");
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
				} // Coloca o novo mínimo no seu lugar correto no vetor

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
