package Hash;

import java.util.LinkedList;
import java.util.Scanner;

public class Hash_String {

	public static int hash(String k) {
		k = k.toLowerCase();
		return Math.abs((k.hashCode() % p) % m);
	}

	public static String[] busca_por(LinkedList<String[]>[] table, String key) {
		String[] res = null;
		int index = hash(key);
		for (int j = 0; j < table[index].size(); j++) {
			res = table[index].get(j);
			if (key.equalsIgnoreCase(res[0])) {
				return res;
			} else
				res = null;
		}
		return res;
	}

	public static String[] busca_ing(LinkedList<String[]>[] table, String key) {
		String[] res = null;
		int index = hash(key);
		for (int j = 0; j < table[index].size(); j++) {
			res = table[index].get(j);
			if (key.equalsIgnoreCase(res[1]))
				return res;
			else
				res = null;
		}
		return res;
	}

	public static int m = 50;
	public static int p = 197;
	public static int u = 100000000; // 00000000 .. 99999999 ==> 0 .. 49

	public static void main(String[] args) {
		String[][] dic = { { "cachorro", "dog" }, { "gato", "cat" }, { "teclado", "keyboard" }, { "rato", "mouse" },
				{ "abacaxi", "pineapple" }, { "faca", "knife" }, { "mar", "sea" }, { "sabonete", "soap" },
				{ "verde", "green" }, { "azul", "blue" }, { "vermelho", "red" }, { "branco", "white" },
				{ "livro", "book" }, { "caneta", "pen" }, { "bicicleta", "bike" }, { "jogo", "game" },
				{ "caixa", "box" }, { "telefone", "phone" }, { "carro", "car" }, { "cadeira", "chair" },
				{ "manual", "manual" }, { "osso", "bone" }, { "outono", "fall" }, { "inverno", "winter" },
				{ "porta", "door" }, { "veleiro", "yacht" }, { "ilha", "island" }, { "zebra", "zebra" },
				{ "zero", "zero" }, { "preto", "black" }, { "árvore", "tree" } };

		// Declaração das tabelas hash
		LinkedList<String[]>[] hashTable_por, hashTable_ing;

		// construindo as tabelas com "m" elementos
		hashTable_por = new LinkedList[m];
		hashTable_ing = new LinkedList[m];

		int[] tabela, num;
		tabela = new int[m];
		num = new int[dic.length];

		for (int i = 0; i < dic.length; i++) {
			System.out.print(dic[i][0] + " ");
		}
		System.out.println();
		System.out.println("HASH de dic:");
		for (int i = 0; i < dic.length; i++) {
			num[i] = hash(dic[i][0]);
			System.out.print(num[i] + "   ");
		}
		System.out.println();

		for (int i = 0; i < num.length; i++) {
			tabela[num[i]]++;
		}
		System.out.println();
		System.out.println("HASH tabela:");
		for (int i = 0; i < tabela.length; i++) {
			System.out.print(tabela[i] + " ");
		}
		System.out.println();
		System.out.println("HASH tabela (Gráfico):");
		for (int i = 0; i < tabela.length; i++) {
			for (int j = 0; j < tabela[i]; j++) {
				System.out.print("#");
			}
			System.out.println();
		}

		// inserindo na hashTable
		for (int i = 0; i < hashTable_por.length; i++) {
			hashTable_por[i] = new LinkedList<String[]>();
			hashTable_ing[i] = new LinkedList<String[]>();
		}
		for (int i = 0; i < dic.length; i++) {
			hashTable_por[hash(dic[i][0])].addFirst(dic[i]);
			hashTable_ing[hash(dic[i][1])].addFirst(dic[i]);
		}
		// Tamanho das Listas em Protuguês
		for (int i = 0; i < hashTable_por.length; i++) {
			System.out.print(hashTable_por[i].size() + " ");
		}
		System.out.println();
		// Tamanho das Listas em Inglês
		for (int i = 0; i < hashTable_ing.length; i++) {
			System.out.print(hashTable_ing[i].size() + " ");
		}
		System.out.println();

		System.out.println("--==<< hashTable (Listas em Português) >>==--");
		for (int i = 0; i < hashTable_por.length; i++) {
			for (int j = 0; j < hashTable_por[i].size(); j++) {
				System.out.print("{" + hashTable_por[i].get(j)[0] + ", " + hashTable_por[i].get(j)[1] + "} => ");
			}
			System.out.println("#");
		}
		System.out.println("--==<< hashTable (Listas em Inglês) >>==--");
		for (int i = 0; i < hashTable_ing.length; i++) {
			for (int j = 0; j < hashTable_ing[i].size(); j++) {
				System.out.print("{" + hashTable_ing[i].get(j)[0] + ", " + hashTable_ing[i].get(j)[1] + "} => ");
			}
			System.out.println("#");
		}

		String[] res;
		res = busca_por(hashTable_por, "gato");
		if (res != null)
			System.out.println(res[0] + " - " + res[1]);
		else
			System.out.println("Palavra não encontrada!!!");

		// Programa de TESTE:
		Scanner leia = new Scanner(System.in);
		int opc = 0;
		String palavra;
		do {
			System.out.println("---- Menu ---");
			System.out.println("[1] Portugês");
			System.out.println("[2] Inglês");
			System.out.println("[0] FIM");
			System.out.println("-------------");
			opc = leia.nextInt();
			leia.nextLine();
			if (opc == 1) {
				System.out.print("Digite a palavra em Português: ");
				palavra = leia.nextLine();
				res = busca_por(hashTable_por, palavra);
				if (res != null)
					System.out.println(res[0] + " = " + res[1]);
				else
					System.out.println("Palavra não encontrada!!!");
			}
			if (opc == 2) {
				System.out.print("Digite a palavra em Inglês: ");
				palavra = leia.nextLine();
				res = busca_ing(hashTable_ing, palavra);
				if (res != null)
					System.out.println(res[1] + " = " + res[0]);
				else
					System.out.println("Palavra não encontrada!!!");
			}
		} while (opc != 0);

	}

}
