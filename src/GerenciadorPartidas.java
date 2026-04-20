
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author henri
 */
public class GerenciadorPartidas {
    private List<Jogo> partidas = new ArrayList<>();

    public GerenciadorPartidas() {
    }

    //Retorna a lista de partidas
    public List<Jogo> getPartidas() {
        return partidas;
    }
    
    //Adiciona uma partida a lista de partidas do sistema
    public void adcPartida(Jogo jogo){
        partidas.add(jogo);
    }
    
    public List<Jogo> buscarPartidaPorTime(String time){
        List<Jogo> resultado = new ArrayList<>();
        
        for(Jogo j : partidas){
            if(j.getTimeCasa().equalsIgnoreCase(time) || j.getTimeFora().equalsIgnoreCase(time)){
                resultado.add(j);
            }
        }
        return resultado;
    }
}
