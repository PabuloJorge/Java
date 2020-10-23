package testes;

public class Imovel {
	

	
		private int codigo;
		private String endereco;
		private double preco;

		public Imovel(int codigo, String endereco, double preco) {
			setCodigo(codigo);
			setEndereco(endereco);
			setPreco(preco);

		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) throws IllegalArgumentException {
			if (codigo <=0) {
				 throw new IllegalArgumentException("Código inválido: "+ codigo);
			}
			this.codigo = codigo;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) throws IllegalArgumentException{
			if ((endereco == null) || (endereco.equals(""))) {
				throw new IllegalArgumentException("Endereço inválido!");
			}
				
				
				this.endereco = endereco;
		}

		public double getPreco() {
			return preco;
		}

		public void setPreco(double preco) throws IllegalArgumentException{
			if (preco <= 0) {
				throw new IllegalArgumentException("Preço inválido!");
			}
			this.preco = preco;
		}

	}


