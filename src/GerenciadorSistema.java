
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */

//Clase destinada a manusear a lista de times e partidas disponíveis no sistema para aposta
public class GerenciadorSistema {
    private List<Jogo> partidas = new ArrayList<>();
    private List<Time> times = new ArrayList<>();

    public GerenciadorSistema() {
    }
    
    //TIMES

    //Retorna a lista de times no sistema
    public List<Time> getTimes() {
        return times;
    }
    
    //Adiciona um time a lista de times no sistema
    public void adcTime(Time time){
        times.add(time);
    }
    
    //Adiciona os uma lista de jogadores a um time
    public void adcJogadoresTime(Time time, List<String> jogadores){
        time.adcJogadores(jogadores);
    }
    
    //Busca um time pelo nome
    public Time buscarTimePorNome(String nome){
        Time resultado = null;
        
        //Percorre a lista de times buscando um time com o nome especificado
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
    
    //Busca todas as partidas de um time pelo nome
    public List<Jogo> buscarPartidaPorTime(String time){
        List<Jogo> resultado = new ArrayList<>();
        
        //Percorre a lista de times buscando os jogos do time com o nome especificado
        for(Jogo j : partidas){
            if(j.getTimeCasa().getNome().equalsIgnoreCase(time) || j.getTimeFora().getNome().equalsIgnoreCase(time)){
                resultado.add(j);
            }
        }
        return resultado;
    }
}
