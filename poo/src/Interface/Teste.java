/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author pablo
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FormaGeometrica[] f = new FormaGeometrica[2];
        f[0] = new Retangulo(2, 4);
        f[1] = new Circulo(5);
        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i].descricao());
        }
    }

}
