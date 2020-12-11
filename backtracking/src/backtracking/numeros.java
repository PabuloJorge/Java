package backtracking;

public class numeros   {

	public static void main(String[] args) {
		int v[] = {1, 2, 3};
		int tamanho = v.length;
		permuta(v, 0, tamanho - 1);
	}

	public static void permuta(int vetor[], int inf, int sup)   {
		if(inf == sup)   {
			// imprime uma permutação
			for(int i = 0; i <= sup; i++)
				System.out.printf("%d ", vetor[i]);
			System.out.printf("\n");
		}
		else   	{
			for(int i = inf; i <= sup; i++)   {
				troca(vetor, inf, i);
				permuta(vetor, inf + 1, sup);
				troca(vetor, inf, i); // backtracking
			}
		}
	}

	public static void troca(int vetor[], int i, int j)   {
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
	}


}
