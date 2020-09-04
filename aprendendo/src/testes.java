import java.util.Scanner;

public class testes {

	public static void main(String[] args) {

		int[] t = { 8, 2, 23, 17, 9 };
		int[] y = { 4, 5, 23, 2, 6 };
		int h = 0;
		for (int i = 0; i < t.length; i++) {
			if (t[i] == y[i])
				h = h + 2;
		}
		System.out.println(h);

	}
}
