
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class Time {
    
    private String nome;
    private List<String> jogadores = new ArrayList<>();

    public Time(String nome) {
        this.nome = nome;
    }

    //Retorna o nome do time
    public String getNome() {
        return nome;
    }

    //Retorna a lista de jogadores do time
    public List<String> getJogadores() {
        return jogadores;
    }
    
    //Adiciona uma lista de jogadores ao time
    public void adcJogadores(List<String> jogadores){
        this.jogadores = jogadores;
    }
    
    
}
