package criptografia;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String texto = "Pablo";
		String textoCifrado = "";
		int letraCifradaASCII = 0;
		int chave= 3;
		letraCifradaASCII = ((int) texto.charAt(0)) + chave;
		textoCifrado = textoCifrado + (char)letraCifradaASCII;
		System.out.println(textoCifrado);
		chave -= 94;
		System.out.println(chave);
		
	}

}
