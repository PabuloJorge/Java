package aprendendoSwing;

import java.awt.*;

public class janelaQuatro {
	public static void main(String[] args) {
		Frame f = new Frame("GridLayout");
		Button botao1 = new Button("B-1");
		Button botao2 = new Button("B-2");
		Button botao3 = new Button("B-3");
		Button botao4 = new Button("B-4");
		Button botao5 = new Button("B-5");
		Button botao6 = new Button("B-6");
		f.setSize(200, 200);
		f.setLayout(new GridLayout(3, 2));
		f.add(botao1);
		f.add(botao2);
		f.add(botao3);
		f.add(botao4);
		f.add(botao5);
		f.add(botao6);
		f.setVisible(true);
	}
}
