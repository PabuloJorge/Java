

public class Conta {
    
    

    private int codigo;
    private double saldo;

    public Conta(int codigo, double saldo) {
        setCodigo(codigo);
        if (saldo > 0) {
            this.saldo = saldo;
        } else {
            this.saldo = 0;
        }

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
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            System.out.println("Codigo inválido: " + codigo);
        }
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    public void Imprimir() {
        System.out.println("Código da conta: "+ codigo);
        System.out.println("Saldo da conta: " + saldo);
    }

    public double Saque(double saque) {
        if (saque > saldo) {
            saque = saldo;
        }
        saldo = saldo - saque;
        return saque;

    }

    public void Creditar(double valor) {
        saldo = saldo + valor;
    }
    /**
     * @param saldo the saldo to set
     */

}

