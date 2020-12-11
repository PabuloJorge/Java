package projeto_banco_de_dados;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmCadastroContas extends JFrame implements ActionListener {
	private Connection con = null;
	JLabel L0, L1, L2, L3, L5, L6, L7, L8, L9, L10, L11, L12;
	JButton b1, b2, b3, b4;
	JTextField tfCodigo, tfNome, tfSaldo;
	JPanel p1 = new JPanel();

	public static void main(String args[]) {
		JFrame Janela = new FrmCadastroContas();
		Janela.show();
		WindowListener x = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		Janela.addWindowListener(x);
	}

	public FrmCadastroContas() {
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.setSize(new Dimension(500, 120));
		L0 = new JLabel(" Tabajara Bank ");
		L0.setFont(new Font("Monotype Corsiva", Font.ITALIC + Font.BOLD, 36));
		L0.setForeground(Color.BLUE);
		L9 = new JLabel(" versão 0.01 ");
		L9.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 28));
		L1 = new JLabel("Código: ");
		L2 = new JLabel("Nome : ");
		L3 = new JLabel("Saldo : ");
		L5 = new JLabel(" ");
		for (int i = 0; i < 90; i++)
			L5.setText(L5.getText() + " ");
		L6 = new JLabel(" ");
		for (int i = 0; i < 15; i++)
			L6.setText(L6.getText() + " ");
		L7 = new JLabel(" ");
		for (int i = 0; i < 180; i++)
			L7.setText(L7.getText() + " ");
		L8 = new JLabel(" ");
		for (int i = 0; i < 16; i++)
			L8.setText(L8.getText() + " ");
		L10 = new JLabel(" ");
		for (int i = 0; i < 200; i++)
			L10.setText(L10.getText() + " ");
		tfCodigo = new JTextField(8);
		tfNome = new JTextField(27);
		tfSaldo = new JTextField(10);

		b1 = new JButton("Inserir");
		b2 = new JButton("Consultar");
		b3 = new JButton("Alterar");
		b4 = new JButton("Remover");
		b1.setBackground(new Color(180, 180, 250));
		b2.setBackground(new Color(180, 180, 250));
		b3.setBackground(new Color(180, 180, 250));
		b4.setBackground(new Color(180, 180, 250));
		p1.add(L0);
		p1.add(L9);
		p1.add(L10);
		p1.add(L1);
		p1.add(tfCodigo);
		p1.add(L5);
		p1.add(L2);
		p1.add(tfNome);
		p1.add(L6);
		p1.add(L3);
		p1.add(tfSaldo);
		p1.add(L7);
		p1.add(L8);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		getContentPane().add(p1);
		setTitle("Tabajara Imobiliária 0.01");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		setSize(470, 280);
		try {
			con = DriverManager.getConnection("jdbc:ucanaccess://C:/intel/Sistema_Bancario_Tabajara.mdb");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "" + e);
		}
	}

	public void actionPerformed(ActionEvent e) {
// clicou no inserir
		if (e.getSource() == b1) {
			inserirConta();
			limpa_campos();
		}
// clicou no consultar
		if (e.getSource() == b2) {
			consultarConta();
// JOptionPane.showMessageDialog(this, "Clicou no consultar");
		}
// clicou no alterar
		if (e.getSource() == b3) {
			alterarConta();
			limpa_campos();
// JOptionPane.showMessageDialog(this, "Clicou no alterar");
		}
// clicou no remover
		if (e.getSource() == b4) {
			removerConta();
// JOptionPane.showMessageDialog(this, "Clicou no remover");
		}
	}

	public void limpa_campos() {
		tfCodigo.setText("");
		tfNome.setText("");
		tfSaldo.setText("");
	}

	public void consultarConta() {
		String numero = tfCodigo.getText();
		try {
			Statement stmt = con.createStatement();
			String query = "SELECT numero, nome_cliente , saldo FROM CONTA WHERE numero=" + numero + "";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				tfNome.setText(rs.getString("nome_cliente"));
				tfSaldo.setText("" + rs.getDouble("saldo"));
			} else {
				JOptionPane.showMessageDialog(this, "Conta não localizada");
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	public void inserirConta() {
		String numero = tfCodigo.getText();
		String nome = this.tfNome.getText();
		double saldo = Double.parseDouble(tfSaldo.getText());
		int numerolinhas = 0;
		try {
			Statement stmt = con.createStatement();
			String query = "INSERT INTO CONTA (numero, nome_cliente, saldo) VALUES(" + numero + " , '" + nome + "' , "
					+ saldo + ")";
			numerolinhas = stmt.executeUpdate(query);
			if (numerolinhas == 1)
				JOptionPane.showMessageDialog(this, "Conta cadastrada com sucesso");

			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			if (numerolinhas == 0)
				JOptionPane.showMessageDialog(this, "Conta já cadastrada !");

		}

	}

	public void alterarConta() {
		String numero = tfCodigo.getText();
		String nome = this.tfNome.getText();
		double saldo = Double.parseDouble(tfSaldo.getText());
		int numerolinhas = 0;
		try {
			Statement stmt = con.createStatement();
			String query = "UPDATE CONTA SET nome_cliente='" + nome + "'" + ", saldo = " + saldo + " WHERE "
					+ "numero =" + numero + "";
			numerolinhas = stmt.executeUpdate(query);
			if (numerolinhas == 1)
				JOptionPane.showMessageDialog(this, "Conta alterada com sucesso");
			else
				JOptionPane.showMessageDialog(this, "Conta não localizada !");
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void removerConta() {
		String numero = tfCodigo.getText();
		int numerolinhas = 0;
		try {
			Statement stmt = con.createStatement();
			String query = "DELETE FROM CONTA WHERE numero =" + numero + "";
			numerolinhas = stmt.executeUpdate(query);
			if (numerolinhas == 1)
				JOptionPane.showMessageDialog(this, "Conta removida com sucesso");
			else
				JOptionPane.showMessageDialog(this, "Conta não localizada !");
			stmt.close();
			limpa_campos();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}