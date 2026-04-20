
import java.util.ArrayList;
import java.util.List;

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
    private static double apostaMax;
    private static double premioMax;
    private List<String> jogadores = new ArrayList<>();
    
    public Jogo() {
    }

    
    public Jogo(int idJogo, String descritivo, double apostaMax, double premioMax) {
        this.idJogo = idJogo;
        this.descritivo = descritivo;
        this.apostaMax = apostaMax;
        this.premioMax = premioMax;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public List<String> getJogadores() {
        return jogadores;
    }
    
    public boolean validarValor(float valor){
        boolean valorPermitido = true;
        
        if(valor > apostaMax){
            valorPermitido = false;
        }
        
        return valorPermitido;
    }
}