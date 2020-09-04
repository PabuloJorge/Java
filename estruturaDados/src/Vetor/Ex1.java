package Vetor;
import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vet = new int[10];
		int par = 0, men = 999999999, cont = 0, soma = 0;
		double media = 0;
		for (int i = 0; i < vet.length; i++) {
			System.out.println("Digite o número:");
			Scanner mp = new Scanner(System.in);
			vet[i] = mp.nextInt();
			soma = soma + vet[i];
			if (vet[i] < men) {
				men = vet[i];

			}
		}
		media = soma / vet.length;
		System.out.println("Menor número é " + men);
		System.out.println("A média é: " + media);
		System.out.println("A soma é: " + soma);
		System.out.println("NÚMEROS PARES");
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] % 2 == 0) {
				System.out.println("Array [" + i + "] =" + vet[i]);
			}
		}
		System.out.println("NÚMEROS MAIORES QUE A MÉDIA");
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] > media) {
				System.out.println("Array [" + i + "] =" + vet[i]);
				cont = cont+1;
			}
		}
		System.out.println("QUANTIDADE DE NÚMEROS MAIORES QUE A MÉDIA: "+cont);
	}

}
