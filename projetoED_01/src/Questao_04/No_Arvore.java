package Questao_04;

public class No_Arvore {

	public String por, ing;
	public No_Arvore L, R;

	public No_Arvore(String p, String i) {
		por = p;
		ing = i;
		L = null;
		R = null;
	}

	public No_Arvore() {
		L = null;
		R = null;
	}

}
