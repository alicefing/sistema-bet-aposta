/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alicefingiro
 */
public class Credito {

    private double saldo;
    private String validade;
    private String moeda;
    private boolean bloqueado;

    
    public Credito() {
    }

    
    public Credito(double saldo, String validade, String moeda, boolean bloqueado) {
        this.saldo = 0.0;
        this.validade = validade;
        this.moeda = moeda;
        this.bloqueado = false;
    }

    public void depositar(double valor) {
        if (bloqueado) {
            System.out.println("Conta bloqueada! Não é possível depositar.");
            return;
        }

        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }

        saldo += valor;
        System.out.println("Depósito realizado! Saldo atual: " + saldo);
    }

    
    public void sacar(double valor) {
        if (bloqueado) {
            System.out.println("Conta bloqueada! Não é possível sacar.");
            return;
        }

        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }

        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
            return;
        }

        saldo -= valor;
        System.out.println("Saque realizado! Saldo atual: " + saldo);
    }

    public double consultarSaldo() {
        return saldo;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

   
    public void bloquear() {
        bloqueado = true;
        System.out.println("Conta bloqueada!");
    }

  
    public void desbloquear() {
        bloqueado = false;
        System.out.println("Conta desbloqueada!");
    }
}
    
}