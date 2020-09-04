/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MegaSena;

/**
 *
 * @author pablo
 */
public class MegaSena {

    private int min;
    private int max;

    public MegaSena(int min, int max) {
        this.min  = min;
        this.max = max;
    }

   

    public int sorteioUnitario() {
        return  this.min + ((int) (Math.random()*(this.max-this.min+1)));
    }

    public int[] sorteioDeValores(int tam) {
        int[] vetor = new int[tam];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = sorteioUnitario();
        }
        return vetor;
    }
}
