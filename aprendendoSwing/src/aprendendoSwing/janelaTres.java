package aprendendoSwing;

import java.awt.*;
import javax.swing.*;

 

public class janelaTres  {
    
    public static void main(String[] args) {
        JFrame f = new JFrame("BorderLayout");
        JButton botao1 = new JButton("B1");
        JButton botao2 = new JButton("B2");
        JButton botao3 = new JButton("B3");
        JButton botao4 = new JButton("B4");
        JButton botao5 = new JButton("B5");
        f.setSize(200,200);
        f.getContentPane().add(botao1, BorderLayout.NORTH);
        f.getContentPane().add(botao2, BorderLayout.SOUTH);
        f.getContentPane().add(botao3, BorderLayout.WEST);
        f.getContentPane().add(botao4, BorderLayout.EAST);
        f.getContentPane().add(botao5, BorderLayout.CENTER);
        f.setVisible(true);    
    }

 

}
