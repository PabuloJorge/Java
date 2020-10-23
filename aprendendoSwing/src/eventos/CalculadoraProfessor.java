package eventos;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalculadoraProfessor extends JFrame implements ActionListener {
	private JLabel L1, L2, L3;
	private JButton B1, B2, B3, B4, B5;
	private JTextField T1, T2, T3;

	public CalculadoraProfessor() {
		setTitle("Calculadora");
		setSize(350, 90);
		getContentPane().setLayout(new GridLayout(3, 4));
		L1 = new JLabel("Num.1");
		L1.setFont(new Font("", Font.BOLD, 14));
		L2 = new JLabel("Num.2");
		L2.setFont(new Font("", Font.BOLD, 14));
		L3 = new JLabel("Total");
		L3.setFont(new Font("", Font.BOLD, 14));
		B1 = new JButton("+");
		B2 = new JButton("-");
		B3 = new JButton("x");
		B4 = new JButton("/");
		B5 = new JButton("Limpar");
		T1 = new JTextField();
		T2 = new JTextField();
		T3 = new JTextField();
		T3.setEditable(false);
		getContentPane().add(L1);
		getContentPane().add(T1);
		getContentPane().add(B1);
		getContentPane().add(B2);
		getContentPane().add(L2);
		getContentPane().add(T2);
		getContentPane().add(B3);
		getContentPane().add(B4);
		getContentPane().add(L3);
		getContentPane().add(T3);
		getContentPane().add(B5);
		B1.addActionListener(this);
		B2.addActionListener(this);
		B3.addActionListener(this);
		B4.addActionListener(this);
		B5.addActionListener(this);

	}

	public static void main(String[] args) {
		JFrame Janela = new CalculadoraProfessor();
		Janela.show();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == B5) {
			T1.setText("");
			T2.setText("");
			T3.setText("");
			return;
		}
		float N1 = 0, N2 = 0, result = 0;
		try {
			N1 = Float.parseFloat(T1.getText());
			N2 = Float.parseFloat(T2.getText());
		} catch (NumberFormatException erro) {
			T3.setText("Erro");
			return;
		}
		if (e.getSource() == B1) {
			result = N1 + N2;
		}
		if (e.getSource() == B2) {
			result = N1 - N2;
		}
		if (e.getSource() == B3) {
			result = N1 * N2;
		}
		if (e.getSource() == B4) {
			result = N1 / N2;
		}
		T3.setText("" + result);
	}

}