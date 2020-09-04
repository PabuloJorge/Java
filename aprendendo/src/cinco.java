import java.util.Scanner;

public class cinco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double m, c;
		System.out.println("Digite o valor em metros:");
		Scanner mp = new Scanner (System.in);
		m = mp.nextDouble();
		c = m*100;
		System.out.println("O valor tem "+c+" centímetros.");	
	}

}
