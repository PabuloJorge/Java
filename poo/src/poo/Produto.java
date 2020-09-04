/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

/**
 *
 * @author pablo
 */
public class Produto {

    private int codigo;
    private String nome;
    private double preco;
    private double desconto_a_vista;

    public Produto(int codigo, String nome, double preco, double desconto_a_vista) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setPreco(preco);
        this.setDesconto_a_vista(desconto_a_vista);
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        if (codigo > 0){
            this.codigo = codigo;
        } else {
            System.out.println("Codigo inválido: "+codigo);
        }
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the desconto_a_vista
     */
    public double getDesconto_a_vista() {
        return desconto_a_vista;
    }

    /**
     * @param desconto_a_vista the desconto_a_vista to set
     */
    public void setDesconto_a_vista(double desconto_a_vista) {
        if ((desconto_a_vista > 0) && (desconto_a_vista <= 100)) {
            this.desconto_a_vista = desconto_a_vista;
        } else {
            this.desconto_a_vista = 0;
        }
    }

    public double getPreco_a_vista() {
        return preco - preco*desconto_a_vista/100;
    }

}
