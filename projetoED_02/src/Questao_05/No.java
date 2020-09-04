/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_05;

/**
 *
 * @author pablo
 */
public class No {
    public int info;
	public No prox;
	
	public No ( int v ){
		info = v;
		prox = null;
	}

	public No ( int v, No p ){
		info = v;
		prox = p;
	}

	
}
