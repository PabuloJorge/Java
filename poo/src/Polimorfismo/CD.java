/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polimorfismo;

/**
 *
 * @author pablo
 */
public class CD extends Produto {

    private String cantor;
    private String produtor;

    public CD(int codigo, String nome, double preco, double desconto_a_vista, String cantor, String produtor) {
        super(codigo, nome, preco, desconto_a_vista);
        this.cantor = cantor;
        this.produtor = produtor;
    }

    /**
     * @return the cantor
     */
    public String getCantor() {
        return cantor;
    }

    /**
     * @param cantor the cantor to set
     */
    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    /**
     * @return the produtor
     */
    public String getProdutor() {
        return produtor;
    }

    /**
     * @param produtor the produtor to set
     */
    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String descricao() {
        return "CLASSE CD\n Código: " + getCodigo() + "\n Nome: " + getNome() + "\nPreço: " + getPreco()
                + "\nDesconto a vista: " + getDesconto_a_vista() + "\n Cantor: " + getCantor() + "\n Produtor: " + getProdutor();

    }
}
