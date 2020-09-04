package Questao_01;

import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;

public class Selection_Sort {

	public static void main(String[] args) {
		// TODO code application logic here
		Scanner leia = new Scanner(System.in);
		int opcao = 0;
		do {
			System.out.println("Escolha a forma de ordenação:");
			System.out.println("0 - Português");
			System.out.println("1 - Inglês");
			opcao = leia.nextInt();
			if (opcao != 0 && opcao != 1) {
				System.out.println("Opção inválida, escolha novamente!");
				System.out.println(" ");
			}
		} while (opcao != 0 && opcao != 1);
		String[][] dic = { { "cachorro", "dog" }, { "gato", "cat" }, { "água", "water" }, { "preto", "black" },
				{ "ola", "hello" }, { "rosa", "pink" }, { "amarelo", "yellow" }, { "vermelho", "red" },
				{ "passaro", "bird" } };
		selectionSort(dic, opcao);
		if (opcao == 0) {
			for (int linha = 0; linha < dic.length; linha++) {
				for (int coluna = 0; coluna < dic[0].length; coluna++) {
					System.out.print(dic[linha][coluna]);
					if (coluna == 0) {
						System.out.print(" → ");
					}
				}
				System.out.println(" ");
			}

		} else if (opcao == 1) {
			for (int linha = 0; linha < dic.length; linha++) {
				for (int coluna = dic[0].length; coluna > 0; coluna--) {
					System.out.print(dic[linha][coluna - 1]);
					if (coluna == 2) {
						System.out.print(" → ");
					}
				}
				System.out.println(" ");
			}
		}
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
