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
public class Livro extends Produto {

    private String autor;
    private String editora;

    public Livro(int codigo, String nome, double preco, double desconto_a_vista, String autor, String editora) {
        super(codigo, nome, preco, desconto_a_vista);
        this.autor = autor;
        this.editora = editora;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String descricao() {
        return "CLASSE LIVRO\n Código: " + getCodigo() + "\n Nome: " + getNome() + "\nPreço: " + getPreco()
                + "\nDesconto a vista: " + getDesconto_a_vista() + "\n Autor: " + getAutor() + "\n Editora: " + getEditora();

    }
}
