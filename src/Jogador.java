/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alicefingiro
 */
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private int idJogador;
    private String nome;
    private String sobrenome;
    private String apelido;
    private String cpf;
    private String nacionalidade;
    private Date dataNascimento;
    
    private Credito credito = new Credito();
    private ArrayList<Aposta> apostas = new ArrayList<>();
    private Time time;


    public Jogador() {
    }


    public Jogador(int idJogador, String nome, String sobrenome, String apelido,
                   String cpf, String nacionalidade, Date dataNascimento) {
        this.idJogador = idJogador;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.apelido = apelido;
        this.cpf = cpf;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
    }
     

    public void cadastrar() {

        // ID
        while (true) {
            this.idJogador = InOut.leIntJogador("Digite o ID do jogador:");
            if (idJogador > 0) break;
            InOut.MsgDeErro("Erro", "ID deve ser positivo!");
        }

        // Nome
        while (true) {
            this.nome = InOut.leStringJogador("Digite o nome:");
            if (nome != null && !nome.trim().isEmpty() && nome.matches("[a-zA-ZÀ-ÿ ]+")) break; 
            InOut.MsgDeErro("Erro", "Nome inválido!");
        }

        // Sobrenome
        while (true) {
            this.sobrenome = InOut.leStringJogador("Digite o sobrenome:");
            if (sobrenome != null && !sobrenome.trim().isEmpty() && sobrenome.matches("[a-zA-ZÀ-ÿ ]+")) break; 
            InOut.MsgDeErro("Erro", "Sobrenome inválido!");
        }

        // Apelido
        while (true) {
            this.apelido = InOut.leStringJogador("Digite o apelido:");
            if (apelido != null && !apelido.trim().isEmpty() && apelido.matches("[a-zA-ZÀ-ÿ ]+")) break; 
            InOut.MsgDeErro("Erro", "Apelido inválido!");
        }

        // CPF
        while (true) {
            this.cpf = InOut.leStringJogador("Digite o CPF:");
            if (cpf != null && cpf.matches("\\d{11}")) break;
            InOut.MsgDeErro("Erro", "CPF inválido! (11 números)");
        }

        // Nacionalidade
        while (true) {
            this.nacionalidade = InOut.leStringJogador("Digite a nacionalidade:");
            if (nacionalidade != null && !nacionalidade.trim().isEmpty() && nacionalidade.matches("[a-zA-ZÀ-ÿ ]+")) break; //!nacionalidade.matches("\\d+") -> verifica se é int
            InOut.MsgDeErro("Erro", "Nacionalidade inválida!");
        }

        // Data
        while (true) {
            try {
                this.dataNascimento = java.sql.Date.valueOf(
                    InOut.leStringJogador("Digite a data (AAAA-MM-DD):")
                );
                break;
            } catch (Exception e) {
                InOut.MsgDeErro("Erro", "Data inválida!");
            }
        }

        InOut.MsgDeInformacao("Cadastro", "Jogador cadastrado com sucesso!");
}
    
    public void criarAposta(GerenciadorSistema sistema) {
        String msgCriarAposta = "=== ESCOLHA A PARTIDA QUE DESEJA APOSTAR ===\n\n";
        
        for(int i = 0; i < sistema.getPartidas().size(); i++){
           msgCriarAposta += "Partida " + (i + 1) + ": " + sistema.getPartidas().get(i).getTimeCasa().getNome()
                   + " VS " + sistema.getPartidas().get(i).getTimeFora().getNome() + "\n";
        }
        
        int opcao = InOut.leInt(msgCriarAposta);

        int tipo = InOut.leIntAposta( // le int com logo de aposta
            "===== TIPOS DE APOSTA =====\n\n" +
            "1 - Gols na partida\n" +
            "2 - Vencedor do jogo\n" +
            "3 - Jogador que faz gol\n\n" +
            "Escolha o tipo:"
        );

        Aposta aposta = new Aposta();
        String timeCasa = sistema.getPartidas().get(opcao - 1).getTimeCasa().getNome();
        String timeFora = sistema.getPartidas().get(opcao - 1).getTimeFora().getNome();
        String partidaAposta = timeCasa + "  VS " + timeFora;
        aposta.setPartidaSelecionada(partidaAposta);

        switch (tipo) {

            case 1 -> {
                int gols = InOut.leIntGol("Quantidade de gols:"); 
                aposta.apostarGols(gols);
            }

            case 2 -> {
                boolean valido;
                String time;
                do{
                    valido = true;
                    time = InOut.leStringTime("Digite o nome do time:\n" +
                        timeCasa + " ou " + timeFora)
                            ; 
                    if(!time.equalsIgnoreCase(timeCasa) && !time.equalsIgnoreCase(timeFora)){
                        InOut.MsgDeAviso("ERROR", "Digite o nome de um dos times da partida selecionada.");
                        valido = false;
                    }
                }while(!valido);
                
                aposta.apostarVencedor(sistema, time);
            }

            case 3 -> {
                boolean valido;
                //mensagem para escolher time
                String escolhatxt = "Deseja apostar em um jogador do qual time?\nOpcão 1: " + timeCasa + 
                        "\nOpção 2: " +  timeFora;
                int escolhaTime, opcaoJogadorTime;
                
                //o jogador escolhe o time do jogador que ele quer apostar
                do
                {
                    escolhaTime = InOut.leIntAposta(escolhatxt);
                }
                while(escolhaTime != 1 && escolhaTime != 2); //loop para caso ele escolha um numero diferente das opcoes 
                
                String msgJogador = 
                "Escolha o jogador que deseja apostar:\n";
                 
                
                // Para o loop não correr o risco de não rodar toda a list
                int max = Math.max(sistema.getPartidas().get(opcao - 1).getJogadoresPartida().get(0).size(), sistema.getPartidas().get(opcao - 1).getJogadoresPartida().get(1).size()); 
                
                //Cria a mensagem com os nomes dos jogadores de cada time
                if(escolhaTime == 1){
                    String txtTimeCasa = "Jogadores do " + timeCasa + ":\n";
                    
                    for(int i = 0; i < max; i++){
                    
                    txtTimeCasa += (i+1) + " - " + sistema.getPartidas().get(opcao - 1).getJogadoresPartida().get(0).get(i) + "\n";
                             
                    }
                    opcaoJogadorTime = InOut.leIntJogador(msgJogador + txtTimeCasa);
                    aposta.apostarJogador(sistema.getPartidas().get(opcao - 1).getJogadoresPartida().get(0).get(opcaoJogadorTime - 1));
                }
                else{
                    String txtTimeFora = "Jogadores do " + timeFora+ ":\n";
                    
                    for(int i = 0; i < max; i++){
                    
                    txtTimeFora+= (i+1) + " - " + sistema.getPartidas().get(opcao - 1).getJogadoresPartida().get(1).get(i) + "\n";
                             
                    }
                    opcaoJogadorTime = InOut.leIntJogador(msgJogador + txtTimeFora);
                    aposta.apostarJogador(sistema.getPartidas().get(opcao - 1).getJogadoresPartida().get(1).get(opcaoJogadorTime - 1));
                } 
            }

            default -> {
                InOut.MsgDeErro("Erro", "Tipo inválido!");
                return;
            }
        }

        double valor = InOut.leDoubleDin("Digite o valor da aposta:"); 

        if (valor <= 0) {
            InOut.MsgDeErro("Erro", "Valor inválido!");
            return;
        }

        if (valor > credito.consultarSaldo()) {
            InOut.MsgDeErro("Erro", "Saldo insuficiente!");
            return;
        }

        aposta.definirValor(valor);

        credito.sacar(valor);
        apostas.add(aposta);

        InOut.MsgDeInformacao("Sucesso", "Aposta criada com sucesso!");
    }
    
    public void cancelarAposta() {

        if (apostas.isEmpty()) {
            InOut.MsgDeErro("Erro", "Não há apostas!");
            return;
        }
        
        String mensagem = "Lista de apostas:\n";
        for (int i = 0; i < apostas.size(); i++) {

        Aposta a = apostas.get(i);
        mensagem += "\nAposta " + (i + 1) + ":\n";

        switch (a.getTipo()) {

            case 1 -> {
                mensagem += "Gols: " + a.getQntdGols() + "\n";
            }

            case 2 -> {
                if (a.getTimeEscolhido() != null) {
                    mensagem += "Time: " + a.getTimeEscolhido().getNome() + "\n";
                }
            }

            case 3 -> {
                if (a.getJogadorEscolhido() != null) {
                    mensagem += "Jogador: " + a.getJogadorEscolhido() + "\n";
                }
            }
        }

        InOut.MsgSemIcone("Apostas", mensagem);
        

        int index = InOut.leInt("Digite o índice da aposta que vai cancelar (0 a " + (apostas.size() - 1) + "):");

        if (index < 0 || index >= apostas.size()) {
            InOut.MsgDeErro("Erro", "Índice inválido!");
            return;
        }

        Aposta aposta = apostas.remove(index);
        credito.depositar(aposta.getValor());

        InOut.MsgDeInformacao("Cancelado", "Aposta cancelada e valor devolvido!");
    }
}
    
    public void menu(GerenciadorSistema sistema) {

    int opcao;

        do {
            opcao = InOut.leIntAposta(
                "==============================\n" +
                "        SISTEMA BET          \n" +
                "==============================\n\n" +
                "1 - Adicionar crédito\n" +
                "2 - Sacar crédito\n" +
                "3 - Consultar saldo\n" +
                "4 - Criar aposta\n" +
                "5 - Listar apostas\n" +
                "6 - Cancelar aposta\n" +
                "7 - Verificar resultados\n" +
                "0 - Sair\n\n" +
                "Digite a opção desejada:"
            );

            switch (opcao) {

                case 1 -> {
                    double valor = InOut.leDoubleDin("Valor para depósito:"); //le double com cifrao
                    credito.depositar(valor);
                }

                case 2 -> {
                    double valor = InOut.leDoubleDin("Valor para saque:"); //le double com cifrao
                    credito.sacar(valor);
                }

                case 3 -> {
                    InOut.MsgDeInformacaoDin("Saldo",
                        "Saldo atual: " + credito.consultarSaldo());
                }

                case 4 -> criarAposta(sistema); 

                case 5 -> listarApostas();

                case 6 -> cancelarAposta();

                case 7 -> {
                    for(int i = 0; i < apostas.size(); i++){
                        InOut.MsgSemIcone("RESULTADO", "Resultado da aposta da partida: " + apostas.get(i).getPartidaSelecionada() + "\n");
                        apostas.get(i).verificarResultado();
                    }
                    
                }

                case 0 -> InOut.MsgDeInformacao("Saindo", "Até logo!");

                default -> InOut.MsgDeErro("Erro", "Opção inválida!");
            }

        } while (opcao != 0);
    }

    
    public void listarApostas(){
        String mensagem = "Lista de apostas:\n";
        for(int i = 0; i < apostas.size(); i++){
            
            if(apostas.get(i).getTipo() == 1){
                mensagem += "Aposta da partida " + apostas.get(i).getPartidaSelecionada() + "\n"+ apostas.get(i).getQntdGols() 
                        + " gol(s) ao total da partida" + "\n";
            }
            if(apostas.get(i).getTipo() == 2){
                mensagem += "Aposta da partida " + apostas.get(i).getPartidaSelecionada() + "\n" 
                        + "Time apostado: "
                        + apostas.get(i).getTimeEscolhido().getNome() + "\n";
            }
            if(apostas.get(i).getTipo() == 3){
                mensagem += "Aposta da partida " + apostas.get(i).getPartidaSelecionada() + "\n" 
                        + "Jogador apostado: "
                        + apostas.get(i).getJogadorEscolhido()+ "\n";
            } 
        }

        InOut.MsgSemIcone("Apostas", mensagem);
    }
}
