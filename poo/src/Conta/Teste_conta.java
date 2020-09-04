/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conta;

/**
 *
 * @author pablo
 */
public class Teste_conta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RepositoriodeContasArray r = new RepositoriodeContasArray(10);
        Conta c = new Conta(8, "Antonio Carlos Silva", 2000);
       
        r.inserir(c);
               
        Conta c2 = r.procurar(8);
        if (c2 == null)
            System.out.println("Conta 8 não existe");
        else
            System.out.println("número: "+c2.getNumero() + " Nome: "+c2.getNome()+ " Saldo: "+c2.getSaldo());
    }
    
}
