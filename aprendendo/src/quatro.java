import java.util.Scanner;

public class quatro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double n1, n2, n3, n4, media;
		System.out.println("Digite as quatro notas: ");
		Scanner mp = new Scanner (System.in);
		n1 = mp.nextDouble();
		n2 = mp.nextDouble();
		n3 = mp.nextDouble();
		n4 = mp.nextDouble();
		media = (n1+n2+n3+n4)/4;
		System.out.println("A sua m�dia � "+media);
		
		

	}

}
