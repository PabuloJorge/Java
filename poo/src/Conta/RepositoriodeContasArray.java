/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conta;

/**
 *
 * @author pablo
 */
public class RepositoriodeContasArray {

    private Conta[] contas;
    private int indice;

    public RepositoriodeContasArray(int tamanho) {
        contas = new Conta[tamanho];
        indice = 0;
    }

    private int procurarIndice(int numero) {
        int i = 0;
        boolean achou;
        for (achou = false; !achou && i < indice;) {
            if (contas[i].getNumero() == numero) {
                achou = true;
            } else {
                i++;
            }
        }
        if (!achou) {
            i = -1;
        }
        return i;

    }

    public Conta procurar(int numero) {
        Conta c = null;

        int i = procurarIndice(numero);
        if (i == -1) {
            return null;
        } else {
            c = contas[i];
            return c;
        }
    }

    public boolean inserir(Conta c) {
        if (indice < contas.length) {
            if (c != null) {
                if (procurar(c.getNumero()) == null) {
                    contas[indice] = c;
                    indice = indice + 1;
                    return true;
                } else {
                    System.out.println("Conta  já cadastrada");
                }
            } else {
                System.out.println("Conta inválida");
            }
        }
        return false;
    }

    public boolean atualizar(Conta c) {
        int i = procurarIndice(c.getNumero());
        if (i != -1) {
            contas[i] = c;
            return true;
        } else {
            return false;
        }
    }

    public boolean remover(int numero) {

        int i = procurarIndice(numero);
        if (i != -1) {
            indice = indice - 1;
            contas[i] = contas[indice];
            contas[indice] = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean existe(int numero) {

        int i = procurarIndice(numero);

        return i != -1;
    }
}


