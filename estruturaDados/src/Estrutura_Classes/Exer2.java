package Estrutura_Classes;
import java.util.Scanner;

public class Exer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner mp = new Scanner(System.in);
		
		aluno a1[] = new aluno[50];
		
		for (int i = 0; i < a1.length; i++) {
			
			a1[i] = new aluno();
			a1[i].notas = new double[6];
			a1[i].endaluno = new endereco();

			System.out.println("Digite o nome do aluno:");
			a1[i].nome = mp.nextLine();

			System.out.println("Curso:");
			a1[i].curso = mp.nextLine();

			System.out.println("Semestre:");
			a1[i].semestre = mp.nextInt();

			System.out.println("Sala:");
			a1[i].sala = mp.nextInt();
            
			System.out.print("Endereço");
			
			System.out.print("Rua:");
			a1[i].endaluno.rua = mp.nextLine();
			
			System.out.print("Bairro:");
			a1[i].endaluno.bairro = mp.nextLine();
			
			System.out.print("Cidade:");
			a1[i].endaluno.cidade = mp.nextLine();
			
			System.out.print("Estado:");
			a1[i].endaluno.estado = mp.nextLine();
			
			System.out.print("CEP:");
			a1[i].endaluno.cep = mp.nextLine();
			
			
			
			for (int j = 0; j < a1[j].notas.length; j++) {
				mp.nextDouble();
                
				System.out.println("Digite a " + j + 1 + "º nota:");
				a1[i].notas[j] = mp.nextDouble();
			}

		}

	}

}
