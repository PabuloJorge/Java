package eventos;

//MouseTracker.java
//Demonstrando eventos do mouse.
//Configura GUI e registra os gerenciadores de eventos
//do mouse (handlers)

//MouseTracker.java
//Demonstrando eventos do mouse.
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventosMouse extends JFrame implements MouseListener, MouseMotionListener {

private JLabel statusBar;

// Configura GUI e registra os gerenciadores de eventos
//do mouse (handlers)
public EventosMouse() {
super( "Demonstrando eventos com o mouse" );
statusBar = new JLabel();
getContentPane().add( statusBar, BorderLayout.SOUTH );
//escuta os próprios eventos de mouse
addMouseListener( this );
addMouseMotionListener( this );
setSize( 575, 400 );
setVisible( true );
}

// tratadores de eventos MouseListener. trata evento quando
//botão do mouse é liberado após pressionado
public void mouseClicked( MouseEvent event ) {

statusBar.setText( "Você clicou em [" + event.getX() +
", " + event.getY() + "]" );
}

// trata evento quando botao do mouse é pressionado
public void mousePressed( MouseEvent event ) {
statusBar.setText( "Botão do mouse Pressionado em [" + event.getX() +
", " + event.getY() + "]" );
}

// trata evento quando botão do mouse é liberado
//após ser arrastado.
public void mouseReleased( MouseEvent event ) {

statusBar.setText( "Botão do mouse solto em [" + event.getX() +
", " + event.getY() + "]" );
}
//trata evento quando o mouse entra em um componente
public void mouseEntered( MouseEvent event ) {
statusBar.setText( "Mouse entrou em [" + event.getX() +
", " + event.getY() + "]" );
getContentPane().setBackground( Color.GREEN );
}

// trata evento quando o mouse sai de um componente
public void mouseExited( MouseEvent event ) {
statusBar.setText( "Mouse fora da janela" );
getContentPane().setBackground( Color.WHITE );
}
//Tratadores de eventos MouseMotionListener
//trata evento quando o usuário arrasta o mouse
//com o botão pressionado.
public void mouseDragged( MouseEvent event ) {
statusBar.setText( "Mouse arrastado em [" + event.getX() +
", " + event.getY() + "]" );
}

// trata evento quando o usuário move o mouse
public void mouseMoved( MouseEvent event ) {
statusBar.setText( "Mouse movido em [" + event.getX() +
", " + event.getY() + "]" );
}
public static void main( String args[] )
{
EventosMouse applicacao = new EventosMouse();
applicacao.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
}

} // fim da classe EventosMouse