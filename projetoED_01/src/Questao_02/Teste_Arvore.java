package Questao_02;

import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;

public class Teste_Arvore {

	// INSERT PRIORIZANDO A PALAVRA EM PORTUGUÊS
	public static No_Arvore insertPt(No_Arvore p, String pt, String in) {
		Collator collator = Collator.getInstance(new Locale("pt", "BR"));
		collator.setStrength(Collator.PRIMARY);
		if (p == null) {
			p = new No_Arvore(pt, in);
			/*
			 * p = new NoTree(); p.info = d; p.L = null; p.R = null;
			 */
			return p;
		} else {
			if (collator.compare(p.por, pt) < 0) {
				p.R = insertPt(p.R, pt, in);
			} else {
				p.L = insertPt(p.L, pt, in);
			}
			return p;
		}
	}

	// INSERT PRIORIZANDO A PALAVRA EM INGLÊS
	public static No_Arvore insertEn(No_Arvore p, String pt, String in) {
		Collator collator = Collator.getInstance(new Locale("pt", "BR"));
		collator.setStrength(Collator.PRIMARY);
		if (p == null) {
			p = new No_Arvore(pt, in);
			/*
			 * p = new NoTree(); p.info = d; p.L = null; p.R = null;
			 */
			return p;
		} else {
			if (collator.compare(p.ing, in) < 0) {
				p.R = insertEn(p.R, pt, in);
			} else {
				p.L = insertEn(p.L, pt, in);
			}
			return p;
		}
	}

	public static void Ler_LDRPT(No_Arvore p) {
		if (p != null) {
			Ler_LDRPT(p.L);
			System.out.print(p.por + " → " + p.ing + " ");
			System.out.println(" ");
			Ler_LDRPT(p.R);
		}
	}

	public static void Ler_LDREN(No_Arvore p) {
		if (p != null) {
			Ler_LDREN(p.L);
			System.out.print(p.ing + " → " + p.por + " ");
			System.out.println(" ");
			Ler_LDREN(p.R);
		}
	}

	public static void main(String[] args) {
		No_Arvore a = new No_Arvore();
		a = null;
		String[][] dic = { { "cachorro", "dog" }, { "gato", "cat" }, { "teclado", "keyboard" }, { "rato", "mouse" },
				{ "abacaxi", "pineapple" }, { "faca", "knife" }, { "mar", "sea" }, { "sabonete", "soap" },
				{ "verde", "green" }, { "azul", "blue" }, { "vermelho", "red" }, { "branco", "white" },
				{ "livro", "book" }, { "caneta", "pen" }, { "bicicleta", "bike" }, { "jogo", "game" },
				{ "caixa", "box" }, { "telefone", "phone" }, { "carro", "car" }, { "cadeira", "chair" },
				{ "manual", "manual" }, { "osso", "bone" }, { "outono", "fall" }, { "inverno", "winter" },
				{ "porta", "door" }, { "veleiro", "yacht" }, { "ilha", "island" }, { "zebra", "zebra" },
				{ "zero", "zero" }, { "preto", "black" } };
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
		if (opcao == 0) {
			// INSERE NA ARVORE
			for (int linha = 0; linha < dic.length; linha++) {
				a = insertPt(a, dic[linha][0], dic[linha][1]);
			}
			Ler_LDRPT(a);

		} else if (opcao == 1) {
			// INSERE NA ARVORE
			for (int linha = 0; linha < dic.length; linha++) {
				a = insertEn(a, dic[linha][0], dic[linha][1]);
			}
			Ler_LDREN(a);
		}
	}

}
