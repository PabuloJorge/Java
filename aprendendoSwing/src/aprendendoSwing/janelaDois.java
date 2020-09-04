package aprendendoSwing;

import java.awt.*;
import javax.swing.*;

 

public class janelaDois extends JFrame  {
    public janelaDois(String titulo)  {
        super(titulo);
        // pega o container do JFrame 
        Container ct = this.getContentPane();
        // modifica o layout do container para FlowLayout
        ct.setLayout(new FlowLayout());
        // cria dois botões para adicionar a janela
        JButton b1 = new JButton("Botão 1");
        JButton b2 = new JButton("Botão 2");// adiciona botões ao container
        ct.add(b1);
        ct.add(b2);
        this.setSize(320,200);
        this.setVisible(true);
    }
    public static void main(String[] args)  {
        new janelaDois("Minha primeira aplicação Swing");
    }
}