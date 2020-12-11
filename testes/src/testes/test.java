package testes;

public class test {

	public static void main(String args[]) {

		/*Imovel p = new Imovel(1, "ads", 1.99);
		System.out.println(p.getCodigo());
		System.out.println(p.getEndereco());
		System.out.println(p.getPreco());*/
		int[ ] t = {8,2,23,17,9};
		int[ ] y  = {4,5,23,2,6};
		int h = 0;
		for (int i = 0;i < t.length; i++ ) {
		     if (t[i] == y[i])
			    h = h +2;
		}
		System.out.println(h);
	}  

}
