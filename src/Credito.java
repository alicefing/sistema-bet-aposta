


public class Credito {

    private double saldo;
    private boolean bloqueado;

    public Credito() {
        this.saldo = 0.0;
        this.bloqueado = false;
    }

    public Credito(double saldo, boolean bloqueado) {
        this.saldo = saldo;
        this.bloqueado = bloqueado;
    }

    public void depositar(double valor) {

        if (bloqueado) {
            InOut.MsgDeErro("Erro", "Conta bloqueada! Não é possível depositar.");
            return;
        }

        if (valor <= 0) {
            InOut.MsgDeErro("Erro", "Valor inválido para depósito.");
            return;
        }

        saldo += valor;
        InOut.MsgDeInformacao("Depósito", "Depósito realizado! Saldo: " + saldo);
    }
    
    public void diminuir(double valor){
        saldo -= valor;
    }
    
    public void aumentar(double valor){
        saldo += valor;
    }

    public void sacar(double valor) {

        if (bloqueado) {
            InOut.MsgDeErro("Erro", "Conta bloqueada! Não é possível sacar.");
            return;
        }

        if (valor <= 0) {
            InOut.MsgDeErro("Erro", "Valor inválido.");
            return;
        }

        if (valor > saldo) {
            InOut.MsgDeErro("Erro", "Saldo insuficiente!");
            return;
        }

        saldo -= valor;
        InOut.MsgDeInformacao("Saque", "Saque realizado! Saldo: " + saldo);
    }

    public double consultarSaldo() {
        return saldo;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void bloquear() {
        bloqueado = true;
        InOut.MsgDeInformacao("Conta", "Conta bloqueada!");
    }

    public void desbloquear() {
        bloqueado = false;
        InOut.MsgDeInformacao("Conta", "Conta desbloqueada!");
    }
}