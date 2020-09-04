package java2d;

import java.awt.*;
import javax.swing.*;

public class java2d_ex01 {
	public static void main(String args[]) {
		JFrame f = new JFrame("Exemplo Linhas, ret�ngulos e ovais");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ex1JPanel painelLRO = new ex1JPanel();
		painelLRO.setBackground(Color.WHITE);
		f.add(painelLRO); // adiciona painel ao frame
		f.setSize(600, 600); // configura o tamanho do frame
		f.setVisible(true); // exibe o frame
	}
}

class ex1JPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		desenhaEixos(g);
	}

	public void desenhaEixos(Graphics g) {
		g.setColor(Color.RED);
		g.drawLine(0, 300, 600, 300);

		g.setColor(Color.RED);
		g.drawLine(300, 0, 300, 600);

		int x = -270;
		for (int i = 30; i < 600; i += 30) {
			g.setColor(Color.RED);
			g.drawLine(i, 295, i, 305);
			if (x != 0) {
				g.drawString(x + "", i - 10, 320);
			}

			x += 30;
		}
	}
}