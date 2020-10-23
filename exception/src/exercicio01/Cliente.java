package exercicio01;

public class Cliente {

	private int codigo;
	private String nome;
	private String cpf;

	public Cliente(int codigo, String nome, String cpf) {
		setCodigo(codigo);
		setNome(nome);
		setCpf(cpf);

	}

	public int getCodigo() {
		return this.codigo;

	}

	public void setCodigo(int codigo) throws IllegalArgumentException {
		if (codigo <= 0) {
			throw new IllegalArgumentException("Código Inválido: " + codigo);
		}
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if ((nome == null) || (nome.equals(""))) {
			throw new IllegalArgumentException("Nome Inválido!");
		}
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws IllegalArgumentException {
		if ((cpf == null) || (cpf.equals(""))) {
			throw new IllegalArgumentException("CPF Inválido!");
		}
		this.cpf = cpf;
	}
	
	
	
	
}
