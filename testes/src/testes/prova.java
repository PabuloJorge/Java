package testes;

import java.util.Scanner;

public class prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		
		int t  = 0;
		int c = 0;
		int n = leia.nextInt();

		if (n<2){
		System.out.println("2");
		} else {
		t = 1;
		c = n;
		while(c >0){
		if ( c % 2 == 0){
		t = t*c;
		}
		c--;
		}
		System.out.println(t);
		}

	}


}
