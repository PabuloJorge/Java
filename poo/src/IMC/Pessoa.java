/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IMC;

/**
 *
 * @author pablo
 */
public class Pessoa {

    private String nome;
    private double peso, altura;
    private int idade;

    public Pessoa(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;

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
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getIMC() {
        double imc = peso / (altura*altura);
        return imc;
    }

    public String getCategoria() {
        double imc = getIMC();
        if (imc < 18.5) {
            return "Abaixo do peso normal!";
        } else if (imc > 18.5 && imc <= 25) {
            return "Peso normal!";
        } else if (imc > 25 && imc <= 30) {
            return "Acima do peso normal!";
        } else {
            return "obeso!";
        }
    }
    public String toString(){
        return "Meu nome é  "+getNome()+", tenho "+getIdade()+" anos e peso "+String.format("%.2f",getPeso())+"Kg . Tenho portando IMC de "+String.format("%.2f",getIMC())+" com categoria  "+getCategoria()+".";
    }

}
