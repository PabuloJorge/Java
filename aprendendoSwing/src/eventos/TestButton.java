package eventos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestButton {
	private static Frame f;
	private static Button b;

	public static void main(String args[]) {
		f = new Frame("Teste de Evento");
		b = new Button("Teste");
		b.addActionListener((ActionListener) new ButtonHandler());
		f.add(b, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}
}

class ButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("Botão Pressionado!");
	}
}