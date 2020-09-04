/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

/**
 *
 * @author pablo
 */
public class POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Produto a = new Produto(-5, "computador", 1000.00, 50);
        
        System.out.println("Codigo do produto: " + a.getCodigo());
        System.out.println("Nome do produto " + a.getNome());
        System.out.println("Preço do produto " + a.getPreco());
        System.out.println("Preço a vista: " + a.getPreco_a_vista());
      
    }

}
