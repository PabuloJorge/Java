package projeto_banco_de_dados;

import java.sql.*;
import java.util.Scanner;

public class teste_BDR2 {
	static Connection con = null;

	public static void main(String[] args) {
		int opcao = 0;
		Scanner s = new Scanner(System.in);
		try {
			con = DriverManager.getConnection("jdbc:ucanaccess://C:/intel/Sistema_Bancario_Tabajara.mdb");
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (opcao != 9) {
			System.out.println("\nSistema Bancário Tabajara\n");
			System.out.println("Digite a sua opção:");
			System.out.println("1 - Cadastrar Conta");
			System.out.println("2 - Consultar Conta");
			System.out.println("3 - Alterar Conta");
			System.out.println("4 - Remover Conta");
			System.out.println("5 - Exibe todas as contas");
			System.out.println("9 - Sair do sistema");
			System.out.print("Sua opção: ");
			opcao = s.nextInt();

			switch (opcao) {
			case 1: // cadastrar conta
// inserirConta();
				break;
			case 2: // consultar conta
// consultarConta();
				break;
			case 3: // alterar conta
// alterarConta();
				break;
			case 4: // remover conta
// removerConta();
				break;
			case 5: // exibe todas as contas
				exibeTodos();

				break;
			}
			try {
				Thread.sleep(4000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
// encerramento do programa...
		System.out.println("Tchau...");
	}

	public static String Leia(String param) {
		java.io.DataInputStream dado_lido;
		String stemporario = "";
		try {
			dado_lido = new java.io.DataInputStream(System.in);
			stemporario = dado_lido.readLine();
		} catch (Exception e) {
		}
		return stemporario;
	}

	public static void exibeTodos() {
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT numero,     nome_cliente , saldo FROM CONTA");
			System.out.println("Contas na base de dados:\n");
			while (rs.next()) {
				System.out.println("cÃ³digo: " + rs.getString("numero") + " nome do cliente: "
						+ rs.getString("nome_cliente") + "  saldo: " + rs.getDouble("saldo"));
			}
			rs.close();
			s.close();
		} catch (Exception e) {
			System.out.println("Hi, deu bronca...");
		}
	}
}
