package calculadora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class calculadoraDois extends JFrame {
      
	public calculadoraDois()  {
       getContentPane().add(new JTextField(),BorderLayout.NORTH);
       JPanel panel = new JPanel();
       panel.setLayout(new GridLayout(5,5));
       panel.add(new JButton("Sen"));
       panel.add(new JButton("Cos"));
       panel.add(new JButton("Tan"));
       panel.add(new JButton("Exp"));
       panel.add(new JButton("+-"));
       panel.add(new JButton("%"));
       panel.add(new JButton("7"));
       panel.add(new JButton("8"));
       panel.add(new JButton("9"));
       panel.add(new JButton("/"));
       panel.add(new JButton("MR"));
       panel.add(new JButton("4"));
       panel.add(new JButton("5"));
       panel.add(new JButton("6"));
       panel.add(new JButton("*"));
       panel.add(new JButton("MEM"));
       panel.add(new JButton("1")); 
       panel.add(new JButton("2"));
       panel.add(new JButton("3"));
       panel.add(new JButton("-"));
       panel.add(new JButton("CE"));
       panel.add(new JButton("0"));
       panel.add(new JButton("."));
       panel.add(new JButton("="));
       panel.add(new JButton("+"));
       getContentPane().add(panel,BorderLayout.CENTER);
       setTitle("Calculadora Java");
     }


    public static void main(String args[])  {
       JFrame calc=new calculadoraDois();
       calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       calc.pack();
       calc.setVisible(true);
    }  
 }


