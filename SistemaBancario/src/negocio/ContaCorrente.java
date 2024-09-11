package negocio;
public class ContaCorrente {
    
    private int id;
    private double saldo;
    private boolean ativa;

    public ContaCorrente(int id, double saldo, boolean ativa) {
        this.id = id;
        this.saldo = saldo;
        this.ativa = ativa;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacarSaldo(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
        }
    }

    public void depositarSaldo(double valor) {
        saldo += valor;
    }
}
