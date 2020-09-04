package aprendendoSwing;

import java.awt.*;
import javax.swing.*;

 

public class janela extends JFrame {
    public janela(String titulo) {
        super(titulo);
        this.setSize(640,480);
        this.setVisible(true);
        
    }

 

public static void main(String[] args) {
    new janela("Minha janela no Java");
}
}