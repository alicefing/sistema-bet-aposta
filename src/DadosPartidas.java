
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author henri
 */

//Classe responsável por simular um banco de dados interno armazenando lista de partidas
public class DadosPartidas {
    
    
    public static List<Jogo> getPartidas(GerenciadorSistema sistema){
        //Cria uma list com todas as próximas partidas disponíveis para aposta
        List<Jogo> partidas = new ArrayList<>();
        
        //Cria novas partidas e as adiciona a lista
        partidas.add(new Jogo(0, sistema.buscarTimePorNome("Flamengo"), sistema.buscarTimePorNome("Atlético-MG"), LocalDate.of(2026, 4, 25)));
        
        partidas.add(new Jogo(1, sistema.buscarTimePorNome("Botafogo"), sistema.buscarTimePorNome("Internacional"), LocalDate.of(2026, 4, 25)));
        
        partidas.add(new Jogo(2, sistema.buscarTimePorNome("Bahia"), sistema.buscarTimePorNome("Santos"), LocalDate.of(2026, 4, 25)));
        
        partidas.add(new Jogo(3, sistema.buscarTimePorNome("Remo"), sistema.buscarTimePorNome("Cruzeiro"), LocalDate.of(2026, 4, 25)));
        
        partidas.add(new Jogo(4, sistema.buscarTimePorNome("São Paulo"), sistema.buscarTimePorNome("Mirassol"), LocalDate.of(2026, 4, 25)));
        
        partidas.add(new Jogo(5, sistema.buscarTimePorNome("Corinthians"), sistema.buscarTimePorNome("Vasco"), LocalDate.of(2026, 4, 25)));
        
        partidas.add(new Jogo(6, sistema.buscarTimePorNome("Grêmio"), sistema.buscarTimePorNome("Coritiba"), LocalDate.of(2026, 4, 25)));
        
        partidas.add(new Jogo(7, sistema.buscarTimePorNome("Bragantino"), sistema.buscarTimePorNome("Palmeiras"), LocalDate.of(2026, 4, 25)));
        
        partidas.add(new Jogo(8, sistema.buscarTimePorNome("Athletico-PR"), sistema.buscarTimePorNome("Vitória"), LocalDate.of(2026, 4, 25)));
        
        partidas.add(new Jogo(9, sistema.buscarTimePorNome("Fluminense"), sistema.buscarTimePorNome("Chapecoense"), LocalDate.of(2026, 4, 25)));
        
        return partidas;
}
}
