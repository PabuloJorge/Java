package exemplos;

import java.util.Scanner;



public class exemplo01 {

 

    public static void main(String [ ] args)   {
        codigoComDefeito();
    }

 

    public static void codigoComDefeito() throws ArrayIndexOutOfBoundsException   {
        int i = 0;
        String nomes[ ] = {"James T. Kirk","Spock", "Leonard McCoy" };
        try  {

 

            while(i < 4 ) {
                System.out.println(nomes[i]);
                i++;
            }
        }
        catch(ArrayIndexOutOfBoundsException e )  {
            System.out.println("Hi cara, deu pau.\n\n Olha só: "+e);
        }

 

    }

 

}
