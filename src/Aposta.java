/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alicefingiro
 */
public class Aposta {

    private int idAposta;
    private double valorAposta;
    
    public Aposta() {
    }

    
    public Aposta(int idAposta, double valorAposta, int repetir) {
        this.idAposta = idAposta;
        this.valorAposta = valorAposta;
    }
    
    public void definirValor(double valor) {
        this.valorAposta = valor;
    }

    public double getValor() {
        return valorAposta;
    }

    public void realizarAposta() {
        System.out.println("Aposta realizada: " + valorAposta);
    }
    
}
