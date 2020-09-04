/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polimorfismo;

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
        Produto p[] = new Produto[3];
        p[0] = new CD(1, "CD", 10.00, 0, "Pablo", "Sofrência");

        p[1] = new Livro(2, "Branca de neve", 20.00, 18.99, "Juquinha", "EVV");

        p[2] = new Produto(3, "Branca de neve", 20.00, 18.99);
        for (int i=0; i<p.length;i++){
            System.out.println(p[i].descricao());
        }

    }

}
