package java2d;

import java.awt.*;
import javax.swing.*;

public class java2d {
	public static void main(String args[]) {
		JFrame frame = new JFrame("Exemplo cores");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ColorJPanel colorJPanel = new ColorJPanel();
		frame.add(colorJPanel);
		frame.setSize(400, 160);
		frame.setVisible(true);
	}
}

class ColorJPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		g.setColor(new Color(255, 0, 0));
		g.fillRect(15, 25, 100, 20);
		g.drawString("Valor RGB: " + g.getColor(), 130, 40);
		g.setColor(Color.BLUE);
		g.fillRect(15, 50, 100, 20);
		g.drawString("Valor RGB: " + g.getColor(), 130, 65);
		// exibe valores individuais de RGB
		Color color = Color.GREEN;
		g.setColor(color);
		g.fillRect(15, 75, 100, 20);
		g.drawString("Valor RGB: " + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue(), 130, 90);
	}
}
