
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
    private Time timeCasa, timeFora;
    private static double apostaMax;
    private static double premioMax;
    private List<String> jogadores = new ArrayList<>();
    
    public Jogo() {
    }

    public Jogo(int idJogo, Time timeCasa, Time timeFora) {
        this.idJogo = idJogo;
        this.timeCasa = timeCasa;
        this.timeFora = timeFora;
    }

    public Time getTimeCasa() {
        return timeCasa;
    }

    public Time getTimeFora() {
        return timeFora;
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