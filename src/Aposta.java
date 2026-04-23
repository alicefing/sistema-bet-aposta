
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alicefingiro
 */
import java.util.Random;

public class Aposta {

    private int idAposta;
    private double valorAposta;

    private Jogador jogador = new Jogador();

    // Tipo da aposta
    private int tipo;

    private int qntdGols;       // tipo 1
    private Time timeEscolhido; // tipo 2
    private int tempoEscolhido;   // tipo 3 
    private String jogadorTime;  // tipo 4


    private int golsPartida;
    private Time vencedor;
    private int tempoResultado;

    public Aposta() {
    }

    public Aposta(int idAposta, double valorAposta, int tipo) {
        this.idAposta = idAposta;
        this.valorAposta = valorAposta;
        this.tipo = tipo;
    }


    public void apostarGols(int gols) {
        this.tipo = 1;
        this.qntdGols = gols;
    }

    public void apostarVencedor(GerenciadorSistema sistema, String time) {
        this.tipo = 2;
        this.timeEscolhido = sistema.buscarTimePorNome(time);
    }

    public void apostarTempo(int tempo) {
        this.tipo = 3;
        this.tempoEscolhido = tempo;
    }
    
    public void apostarJogador(String jogadorEscolhido) {
        this.tipo = 4;
        this.jogadorTime = jogadorEscolhido;
    }

   

    public void realizarAposta(GerenciadorSistema sistema) {
        System.out.println("Aposta #" + idAposta + " realizada no valor de R$ " + valorAposta);
        String mensagem = "Selecione o time que deseja apostar:\n";
        for(int i = 0; i < sistema.getPartidas().size(); i++)
        {
            mensagem += (i + 1) + " " + sistema.getPartidas().get(i).getTimeCasa() + "X" + sistema.getPartidas().get(i).getTimeFora() + "\n";
        }
        
       
        apostarVencedor(sistema, InOut.leString(mensagem)); 
        
    }

  

    //public void gerarResultado() {
        //Random rand = new Random();

        //golsPartida = rand.nextInt(8); 

        //String[] times = {"Time A", "Time B"};
        //vencedor = times[rand.nextInt(2)];

        //tempoResultado = rand.nextInt(3); 
    //}

    public void verificarResultado() {

        System.out.println("\n--- RESULTADO DA APOSTA " + idAposta + " ---");

        switch (tipo) {

            case 1:
                System.out.println("Gols na partida: " + golsPartida);

                if (golsPartida > qntdGols) {
                    System.out.println("Acertou!");
                    System.out.println("Ganhou: R$ " + (valorAposta * 2));
                } else if (golsPartida == qntdGols) {
                    System.out.println("Quase!");
                    System.out.println("Ganhou: R$ " + (valorAposta * 1.2));
                } else {
                    System.out.println("Errou!");
                }
                break;

            case 2: 
                System.out.println("Vencedor: " + vencedor);

                if (vencedor.equals(timeEscolhido)) {
                    System.out.println("Acertou!");
                    System.out.println("Ganhou: R$ " + (valorAposta * 2.5));
                } else {
                    System.out.println("Errou!");
                }
                break;

            case 3:
                System.out.println("Tempo do gol: " + tempoResultado);

                if (tempoResultado == tempoEscolhido) {
                    System.out.println("Acertou!");
                    System.out.println("Ganhou: R$ " + (valorAposta * 3));
                } else {
                    System.out.println("Errou!");
                }
                break;

            default:
                System.out.println("Tipo de aposta inválido!");
        }
    }

    public int getIdAposta() {
        return idAposta;
    }

    public double getValor() {
        return valorAposta;
    }
    
    public void definirValor(double valor){
        this.valorAposta = valor;
    }

    public int getTipo() {
        return tipo;
    }

    public int getLimiteGols() {
        return qntdGols;
    }

    public Time getTimeEscolhido() {
        return timeEscolhido;
    }

    public int getTempoEscolhido() {
        return tempoEscolhido;
    }

    public String getJogadorTime() {
        return jogadorTime;
    }

    
    
    
    
    
}
