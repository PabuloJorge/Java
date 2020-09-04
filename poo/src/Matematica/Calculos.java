/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matematica;

/**
 *
 * @author pablo
 */
public class Calculos {

    public static void Tabuada(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + n * i);
        }
    }

    public static int Fatorial(int n) {
        int fat = 1;
        for (int i = 1; i <= n; i++) {
            fat *= i;
        }
        return fat;
    }

       public static double senx(double x, int n)  {
        double result = 0;
        int cont = 1;
        boolean sinalpositivo = true;
        while (cont <=n)  {
            if (sinalpositivo)  {
                   result = result + Math.pow(x, cont)/Fatorial(cont);
                   sinalpositivo = false;
            }
            else  {
                   result = result - Math.pow(x, cont)/Fatorial(cont);
                   sinalpositivo = true;
            }
            cont = cont +2;
        }
        return result;
    }

}
