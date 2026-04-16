/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alicefingiro
 */
public class Jogo {

    private int idJogo;
    private String descritivo;
    private double apostaMax;
    private double premioMax;

    
    public Jogo() {
    }

    
    public Jogo(int idJogo, String descritivo, double apostaMax, double premioMax) {
        this.idJogo = idJogo;
        this.descritivo = descritivo;
        this.apostaMax = apostaMax;
        this.premioMax = premioMax;
    }
}