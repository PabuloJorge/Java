package Questao_02;

public class Teste {

	public static void main(String[] args) {
		// TODO code application logic here
		Lista_Vetor lista = new Lista_Vetor();
		lista.addLast(10);
		lista.addLast(20);
		lista.addLast(30);
		System.out.println(lista);
		System.out.println(lista.get(0));
		System.out.println(lista.remove(1));
		System.out.println(lista);
		System.out.println(lista.set(1, 100));
		System.out.println(lista);
		System.out.println(lista.media());

		

	}
}
