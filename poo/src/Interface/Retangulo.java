/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author pablo
 */
public class Retangulo implements FormaGeometrica {

    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;

    }

    public double getArea() {
        return getBase() * getAltura();

    }

    public String descricao() {
        return "CLASSE RETÂNGULO" + "\nBASE: " + getBase() + "\n ALTURA: " + getAltura() + "\n ÁREA: " + getArea();

    }

    /**
     * @return the base
     */
    public double getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(double base) {
        this.base = base;
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

}
