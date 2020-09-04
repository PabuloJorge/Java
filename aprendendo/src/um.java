
public class um {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 0, 9, 4, 7, 128, 42, -1, 301, -5 };
		int resultado = buscarDivisivelPor(array, 2);
		System.out.println(resultado);

	}

	public static int buscarDivisivelPor(int array[], int num) {
		// Escreva abaixo o seu código:
		for (int i = 0; i < array.length; i++) {
			if (array[i] % num == 0 && array[i] != 0) {
				return array[i];
			}
		}
		return -1;

	}
}
