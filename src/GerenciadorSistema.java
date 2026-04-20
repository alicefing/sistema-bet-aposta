
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
public class GerenciadorSistema {
    private List<Jogo> partidas = new ArrayList<>();
    private List<Time> times = new ArrayList<>();

    public GerenciadorSistema() {
    }
    
    //TIMES

    public List<Time> getTimes() {
        return times;
    }
    
    public void adcTime(Time time){
        times.add(time);
    }
    
    public Time buscarTimePorNome(String nome){
        Time resultado = null;
        
        for (Time t : times){
            if(t.getNome().equalsIgnoreCase(nome)){
                resultado = t;
            }
        }
        return resultado;
    }
    
    
    
    //JOGOS
    
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
            if(j.getTimeCasa().getNome().equalsIgnoreCase(time) || j.getTimeFora().getNome().equalsIgnoreCase(time)){
                resultado.add(j);
            }
        }
        return resultado;
    }
}
