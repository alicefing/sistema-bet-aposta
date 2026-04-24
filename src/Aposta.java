import java.util.Random;

public class Aposta {

    private int idAposta;
    private double valorAposta;

    private int tipo;

    private int qntdGols;
    private Time timeEscolhido;
    private String jogadorEscolhido;

    private int golsPartida;
    private Time vencedor;
    private String jogadorGols;

    public Aposta() {}

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

    public void apostarJogador(String jogador) {
        this.tipo = 3;
        this.jogadorEscolhido = jogador;
    }

    public void realizarAposta(GerenciadorSistema sistema) {

        String mensagem = "Selecione o time:\n";

        for (int i = 0; i < sistema.getPartidas().size(); i++) {
            mensagem += (i + 1) + " - " +
                sistema.getPartidas().get(i).getTimeCasa().getNome() +
                " X " +
                sistema.getPartidas().get(i).getTimeFora().getNome() + "\n";
        }

        String time = InOut.leString(mensagem);
        apostarVencedor(sistema, time);
    }

    public void verificarResultado() {

        System.out.println("\n--- RESULTADO DA APOSTA " + idAposta + " ---");

        switch (tipo) {

            case 1 -> {
                System.out.println("Gols na partida: " + golsPartida);

                if (golsPartida > qntdGols) {
                    System.out.println("Acertou!");
                } else if (golsPartida == qntdGols) {
                    System.out.println("Quase!");
                } else {
                    System.out.println("Errou!");
                }
            }

            case 2 -> {
                System.out.println("Vencedor: " + vencedor);

                if (vencedor != null && vencedor.equals(timeEscolhido)) {
                    System.out.println("Acertou!");
                } else {
                    System.out.println("Errou!");
                }
            }

            case 3 -> {
                System.out.println("Jogador: " + jogadorGols);

                if (jogadorGols != null && jogadorGols.equals(jogadorEscolhido)) {
                    System.out.println("Acertou!");
                } else {
                    System.out.println("Errou!");
                }
            }

            default -> System.out.println("Tipo inválido!");
        }
    }

    public int getIdAposta() {
        return idAposta;
    }

    public double getValor() {
        return valorAposta;
    }

    public void definirValor(double valor) {
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

    public String getJogadorEscolhido() {
        return jogadorEscolhido;
    }
}