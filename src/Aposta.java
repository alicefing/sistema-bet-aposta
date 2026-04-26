
import java.util.List;

public class Aposta {

    private int idAposta;
    private double valorAposta;

    private int tipo;

    private int qntdGols;
    private Time timeEscolhido;
    private String jogadorEscolhido;
    private String partidaSelecionada;

    private Jogo jogo; // A APOSTA DEPENDE DO JOGO

    public Aposta() {}

    public Aposta(int idAposta, double valorAposta, int tipo, Jogo jogo) {
        this.idAposta = idAposta;
        this.valorAposta = valorAposta;
        this.tipo = tipo;
        this.jogo = jogo;
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

        String mensagem = "Selecione o jogo:\n";

        for (int i = 0; i < sistema.getPartidas().size(); i++) {
            mensagem += (i + 1) + " - " +
                sistema.getPartidas().get(i).getTimeCasa().getNome() +
                " X " +
                sistema.getPartidas().get(i).getTimeFora().getNome() + "\n";
        }

        int opcao = InOut.leInt(mensagem);

        this.jogo = sistema.getPartidas().get(opcao - 1);
    }

    public void verificarResultado() {

        switch (tipo) {

            case 1 -> {
                int totalGols = jogo.getGolsCasa() + jogo.getGolsFora();
                
                InOut.MsgSemIcone("RESULTADO", "Total de gols: " + totalGols);

                if (totalGols > qntdGols) {
                    InOut.MsgSemIcone("RESULTADO", "Acertou!");
                } else if (totalGols == qntdGols) {
                    InOut.MsgSemIcone("RESULTADO", "Quase!");
                } else {
                    InOut.MsgSemIcone("RESULTADO", "Errou!");
                }
            }

            case 2 -> {

                Time vencedor = jogo.getVencedor();

                if (vencedor == null) {
                    InOut.MsgSemIcone("RESULTADO", "Empate!");
                } else {
                    InOut.MsgSemIcone("RESULTADO", vencedor.getNome());
                    
                }

                if (vencedor != null && vencedor.equals(timeEscolhido)) {
                    InOut.MsgSemIcone("RESULTADO", "Acertou!");
                } else {
                    InOut.MsgSemIcone("RESULTADO", "Errou!");
                }
            }

            case 3 -> {

                List<String> marcadoresGols = jogo.getMarcadoresGol();
                
                System.out.println("Jogador: simulado");

                if (jogadorEscolhido != null && jogo.getMarcadoresGol().contains(jogadorEscolhido)) {
                    InOut.MsgSemIcone("RESULTADO", "Acertou!");  
                } else {
                    InOut.MsgSemIcone("RESULTADO", "Errou!");
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

    public int getQntdGols() {
        return qntdGols;
    }

    public Time getTimeEscolhido() {
        return timeEscolhido;
    }

    public String getJogadorEscolhido() {
        return jogadorEscolhido;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
    

    public void setPartidaSelecionada(String partidaSelecionada) {
        this.partidaSelecionada = partidaSelecionada;
    }

    public String getPartidaSelecionada() {
        return partidaSelecionada;
    }
    
    
}