package calculadora;

import javax.swing.*;

import java.awt.*;

public class calculadora {
	public static void main(String[] args) {
		JPanel p = new JPanel();
		JFrame f = new JFrame("Calculadora");
		JButton botao1 = new JButton("sen");
		JButton botao2 = new JButton("cos");
		JButton botao3 = new JButton("tan");
		JButton botao4 = new JButton("EXP");
		JButton botao5 = new JButton("±");
		JButton botao6 = new JButton("%");
		JButton botao7 = new JButton("7");
		JButton botao8 = new JButton("8");
		JButton botao9 = new JButton("9");
		JButton botao10 = new JButton("/");
		JButton botao11 = new JButton("MR");
		JButton botao12 = new JButton("4");
		JButton botao13 = new JButton("5");
		JButton botao14 = new JButton("6");
		JButton botao15 = new JButton("*");
		JButton botao16 = new JButton("MEM");
		JButton botao17 = new JButton("1");
		JButton botao18 = new JButton("2");
		JButton botao19 = new JButton("3");
		JButton botao20 = new JButton("-");
		JButton botao21 = new JButton("CE");
		JButton botao22 = new JButton("0");
		JButton botao23 = new JButton(".");
		JButton botao24 = new JButton("=");
		JButton botao25 = new JButton("+");
		JTextField texto = new JTextField("0");
		f.setSize(400, 400);
		p.setLayout(new GridLayout(5, 5));
		p.add(botao1);
		p.add(botao2);
		p.add(botao3);
		p.add(botao4);
		p.add(botao5);
		p.add(botao6);
		p.add(botao7);
		p.add(botao8);
		p.add(botao9);
		p.add(botao10);
		p.add(botao11);
		p.add(botao12);
		p.add(botao13);
		p.add(botao14);
		p.add(botao15);
		p.add(botao16);
		p.add(botao17);
		p.add(botao18);
		p.add(botao19);
		p.add(botao20);
		p.add(botao21);
		p.add(botao22);
		p.add(botao23);
		p.add(botao24);
		p.add(botao25);
		f.add(texto, BorderLayout.NORTH);
		f.add(p, BorderLayout.CENTER);
		f.setVisible(true);

	}
}
