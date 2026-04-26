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

        System.out.println("\n--- RESULTADO DA APOSTA " + idAposta + " ---");

        switch (tipo) {

            case 1 -> {
                int totalGols = jogo.getGolsCasa() + jogo.getGolsFora();

                System.out.println("Total de gols: " + totalGols);

                if (totalGols > qntdGols) {
                    System.out.println("Acertou!");
                } else if (totalGols == qntdGols) {
                    System.out.println("Quase!");
                } else {
                    System.out.println("Errou!");
                }
            }

            case 2 -> {

                Time vencedor = jogo.getVencedor();

                if (vencedor == null) {
                    System.out.println("Empate!");
                } else {
                    System.out.println("Vencedor: " + vencedor.getNome());
                }

                if (vencedor != null && vencedor.equals(timeEscolhido)) {
                    System.out.println("Acertou!");
                } else {
                    System.out.println("Errou!");
                }
            }

            case 3 -> {

                System.out.println("Jogador: simulado");

                if (jogadorEscolhido != null &&
                    jogadorEscolhido.equals("Jogador X")) {

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

    public void setPartidaSelecionada(String partidaSelecionada) {
        this.partidaSelecionada = partidaSelecionada;
    }

    public String getPartidaSelecionada() {
        return partidaSelecionada;
    }
    
    
}