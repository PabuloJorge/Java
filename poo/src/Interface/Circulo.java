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
public class Circulo implements FormaGeometrica {

    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getArea() {
        return Math.PI * (Math.pow(getRaio(), 2));

    }

    public String descricao() {
        return "CLASSE CÍRCULO" + "\nRAIO: " + getRaio() + "\n ÁREA: " + getArea();
    }

    /**
     * @return the raio
     */
    public double getRaio() {
        return raio;
    }

    /**
     * @param raio the raio to set
     */
    public void setRaio(double raio) {
        this.raio = raio;
    }

}
