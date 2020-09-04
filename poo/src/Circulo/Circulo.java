/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circulo;

/**
 *
 * @author pablo
 */
public class Circulo {

    private double raio;

    
    public Circulo(double raio){
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    public double getArea(){
        return Math.PI*raio*raio;
    }
    public double getComprimento(){
       return 2*Math.PI*raio; 
    }
    public String toString(){
        return "Círculo com Raio: "+getRaio()+", Área: "+String.format("%.2f",getArea())+", Comprimento:"+String.format("%.2f",getComprimento())+".";
                
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
