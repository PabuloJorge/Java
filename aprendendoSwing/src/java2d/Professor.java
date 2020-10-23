package java2d;

import java.awt.*;
import java.awt.geom.Line2D;

 

import javax.swing.*;

 

public class Professor extends JFrame   {

 

    public static final int LARGURA = 600;
    public static final int ALTURA = 600;
    private PainelPlanoCartesiano pPC;

 

    public Professor()  {
        super.setTitle("Janela");
        PainelPlanoCartesiano pPC = new PainelPlanoCartesiano(Professor.LARGURA, Professor.ALTURA);
        getContentPane().add(pPC);
        setBounds(300, 30, Professor.LARGURA + 17, Professor.ALTURA + 40);
        setResizable(false);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

 

    public static void main(String[] args) {
        new Professor();
    }
}

 

 

class PainelPlanoCartesiano extends JPanel {

 

    private int largura;
    private int altura;

 

    public PainelPlanoCartesiano(int l, int a)  {
        largura = l;
        altura = a;
        setSize(l,a);
    }
    public void paintComponent(Graphics g)  {
        super.paintComponent(g);

 

        desenhaQuadriculado(g);

 

        desenhaEixos(g);

 

        escreveValoresEixo_X(g);

 

        escreveValoresEixo_Y(g);

        plotaReta(g);

    }

 
public void plotaReta(Graphics g) {
	g.setColor(Color.BLUE);
	
	g.drawLine(0,altura,largura,0);
	
	
	
}

public void plotaFuncaoQuadratica() {
	
}

public void desenhafuncaoQuadraticaProfessor(Graphics g)  {
    g.setColor(Color.BLUE);




    double  xantigo = -200, yantigo = (xantigo*xantigo)/50 - 50;
    double y = 0;
    for(double x = -250; x<=150;x=x+0.0001)  {




        y = (x*x)/50 - 50;
        g.drawLine(300+(int) xantigo,300-(int) yantigo,300+(int) x,300-(int) y);
        yantigo = y;
        xantigo = x;



    }



}
 

    public void desenhaEixos(Graphics g)  {
        g.setColor(Color.BLACK);
        
        g.drawLine(largura,largura/2,altura,largura/2);

 

        // desenha o eixo y (ordenada)
        g.drawLine(altura/2,0,altura/2,largura);

 

        // desenha o eixo x (abscissa)
        g.drawLine(0,altura/2,largura,altura/2);

 

    }

 

    public void escreveValoresEixo_X(Graphics g)  {
        g.setColor(Color.BLACK);
        // escreve valores e marcas no eixo X positivo
        for (int i = 30; i < 300;i=i+30)  {
            g.drawLine((largura/2)+i, altura/2 - 4, (largura/2)+i, altura/2 + 4);
            g.drawString( "" + i, (largura/2)+i - 5, altura/2 + 20 );

 

        }

 

        // escreve valores e marcas no eixo X negativo
        for (int i = -270; i < 0;i=i+30)  {
            g.drawLine((largura/2)+i, altura/2 - 4, (largura/2)+i, altura/2 + 4);
            g.drawString( "" + i, (largura/2)+i -10, altura/2 + 20 );
        }

 


    }

 


    public void escreveValoresEixo_Y(Graphics g)  {
        g.setColor(Color.BLACK);
        // escreve valores e marcas no eixo Y positivo
        for (int i = 30; i < 300;i=i+30)  {
            g.drawLine((largura/2)-4, altura/2 -i, (largura/2)+4, altura/2 -i);
            g.drawString( "" + i, (largura/2) + 10, altura/2 -i +5 );

 

        }

 

        // escreve valores e marcas no eixo Y negativo
        for (int i = -270; i < 0;i=i+30)  {
            g.drawLine((largura/2)-4, altura/2 -i, (largura/2)+4, altura/2 -i);
            g.drawString( "" + i, (largura/2) + 10, altura/2 -i +5 );
        }

 


    }

 


    public void desenhaQuadriculado(Graphics g)  {
        // desenha o quadriculado do plano
        // (linhas verticais)
        g.setColor(new Color(204,204,204));

 

        for(int i = 0; i < altura; i = i + 10)   {
            g.drawLine(i, 0, i, largura);
        }

 

        // desenha o quadriculado do plano
        // (linhas horizontais)
        for(int i = 0; i < largura; i=i+10){
            g.drawLine(0, i, altura, i);
        }

 

 

    }

 

    
}
