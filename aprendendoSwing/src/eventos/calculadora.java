package eventos;

import javax.swing.*;

import java.awt.*;

public class calculadora {
	public static void main(String[] args) {
		JPanel p = new JPanel();
		JFrame f = new JFrame("Calculadora");
		JButton botao1 = new JButton("+");
		JButton botao2 = new JButton("-");
		JButton botao3 = new JButton("x");
		JButton botao4 = new JButton("/");
		JButton botao5 = new JButton("Limpar");
		JLabel resultado = new JLabel("");
		JTextField num1 = new JTextField("");
		JTextField num2 = new JTextField("");

		f.setSize(400, 200);
		p.setLayout(new GridLayout(3, 4));
		p.add(num1);
		p.add(botao1);
		p.add(botao2);
		p.add(num2);
		p.add(botao3);
		p.add(botao4);
		p.add(resultado);
		p.add(botao5);
		f.add(p, BorderLayout.CENTER);

		JPanel p1 = new JPanel();
		JLabel nume1 = new JLabel("Número 1");
		JLabel nume2 = new JLabel("Número 2");
		JLabel total = new JLabel("Total");
		
		p1.setLayout(new GridLayout(3, 1));
		p1.add(nume1);
		p1.add(nume2);
		p1.add(total);
		f.add(p1, BorderLayout.WEST);

		f.setVisible(true);

	}
}
