/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao_03;

/**
 *
 * @author pablo
 */
public class No {
    public char info;
	public No prox;
	
	public No ( char v ){
		info = v;
		prox = null;
	}

	public No ( char v, No p ){
		info = v;
		prox = p;
	}

	
}
