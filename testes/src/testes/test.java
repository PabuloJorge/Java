package testes;

public class test {

	public static void main(String args[]) {

		Imovel p = new Imovel(1, "ads", 1.99);
		System.out.println(p.getCodigo());
		System.out.println(p.getEndereco());
		System.out.println(p.getPreco());
	}
}
