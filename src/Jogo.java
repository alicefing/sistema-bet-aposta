


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {

    private int idJogo;
    private Time timeCasa, timeFora;
    private LocalDate data;
    private List<List<String>> jogadoresPartida = new ArrayList<>();

    // RESULTADO
    private int golsCasa;
    private int golsFora;
    private Time vencedor;

    public Jogo(int idJogo, Time timeCasa, Time timeFora, LocalDate data) {
        this.idJogo = idJogo;
        this.timeCasa = timeCasa;
        this.timeFora = timeFora;
        this.data = data;
    }

    public Time getTimeCasa() {
        return timeCasa;
    }

    public Time getTimeFora() {
        return timeFora;
    }

    public int getGolsCasa() {
        this.gerarResultado();
        return golsCasa;
    }

    public int getGolsFora() {
        this.gerarResultado();
        return golsFora;
    }

    public Time getVencedor() {
        this.gerarResultado();
        return vencedor;
    }
    
    //Retorna uma lis contendo as listas de jogadores de cada time
    public List<List<String>> getJogadoresPartida() {
        jogadoresPartida.add(timeCasa.getJogadores());
        jogadoresPartida.add(timeFora.getJogadores());
        
        return jogadoresPartida;
    }

    
    // RESULTADO É DO JOGO
    public void gerarResultado() {
        Random r = new Random();

        golsCasa = r.nextInt(6);
        golsFora = r.nextInt(6);

        if (golsCasa > golsFora) {
            vencedor = timeCasa;
        } else if (golsFora > golsCasa) {
            vencedor = timeFora;
        } else {
            vencedor = null; // empate
        }
    }
}