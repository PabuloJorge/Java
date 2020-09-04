package java2d;

import java.awt.*;
import javax.swing.*;

public class java2d_ex {
	public static void main(String args[]) {
		JFrame f = new JFrame("Exemplo Linhas, retângulos e ovais");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		exJPanel painelLRO = new exJPanel();
		painelLRO.setBackground(Color.WHITE);
		f.add(painelLRO); // adiciona painel ao frame
		f.setSize(600, 600); // configura o tamanho do frame
		f.setVisible(true); // exibe o frame
	}
}

class exJPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		desenhaQuadriculado(g);
		desenhaEixos(g);
	}

	public void desenhaEixos(Graphics g) {
		g.setColor(Color.RED);
		g.drawLine(0, 300, 600, 300);

		g.setColor(Color.RED);
		g.drawLine(300, 0, 300, 600);
	}

	public void desenhaQuadriculado(Graphics g) {
		g.setColor(new Color(204, 204, 204));
		for (int i = 0; i < 600; i += 10) {
			g.drawLine(0, i, 600, i);
		}

		for (int i = 0; i < 600; i += 10) {
			g.drawLine(i, 0, i, 600);
		}
	}
}
