package Matriz;
import java.util.Scanner;

public class Matriz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner mp = new Scanner(System.in);
		int mat[][] = new int[3][3];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.println("Digite o valor da posição[" + i + "][" + j + "]");
				mat[i][j] = mp.nextInt();

			}
		}
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
}