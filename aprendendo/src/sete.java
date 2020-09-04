import java.util.Scanner;

public class sete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double l=0, a=0, r = 0;
System.out.println("Digite o lado do quadrado:");
Scanner mp = new Scanner (System.in);
l = mp.nextDouble();
System.out.println("O dobro do lado do quadrado é "+lado(l, a, r));

	}
public static double lado (double l, double a, double r) {
	a = l*l;
	r = a*2;
	return r;
	
}
}
