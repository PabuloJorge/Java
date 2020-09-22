package criptografia;

import java.util.Scanner;

public class Resolucao01 {
	public static void main(String[] args)  {

		 

        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe o texto a ser descriptografado: ");
        String textoCriptografado = entrada.nextLine();
        System.out.println("\n Resultados: \n");
        String textoDescriptografado;
        for (int i = 1;i<=26;i++)  {
            StringBuilder texto = new StringBuilder();
            // Variavel com tamanho do texto a ser decriptado
            int tamanhoTexto = textoCriptografado.length();
            int letraDecifradaASCII=0;
            // Descriptografa cada caractere por vez
            for(int c=0; c < tamanhoTexto; c++){
                // pega o código ASCII do caractere 
                int letracifradaASCII = (int) textoCriptografado.charAt(c);
                // Descriptografa caractere menos espaços = 32)
                if (letracifradaASCII != 32)
                             letraDecifradaASCII = ((int) textoCriptografado.charAt(c)) - i;
                else
                    letraDecifradaASCII = ((int) textoCriptografado.charAt(c));
                // Verifica se o codigo ASCII esta no limite dos caracteres 
                // imprimiveis
                while(letraDecifradaASCII < 32)
                    letraDecifradaASCII += 94;
                    // Transforma codigo ASCII descriptografado em         
                // caractere 
                    // e anexa ao novo texto descriptografado
                    texto.append( (char)letraDecifradaASCII );
                }
                System.out.println("Chave " + i + ": "+texto);
                }
            }
}
