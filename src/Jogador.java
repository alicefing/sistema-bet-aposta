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
     

    public boolean cadastrar() {

        System.out.println("Cadastro do jogador: ");
        this.idJogador = InOut.leInt("Digite o ID do jogador:"); //fazer tratamento de erro
        this.nome = InOut.leString("Digite o nome:"); //fazer tratamento de erro
        this.sobrenome = InOut.leString("Digite o sobrenome:"); //fazer tratamento de erro
        this.apelido = InOut.leString("Digite o apelido:"); //fazer tratamento de erro
        this.cpf = InOut.leString("Digite o CPF:"); //fazer tratamento de erro
        this.nacionalidade = InOut.leString("Digite a nacionalidade:"); //fazer tratamento de erro
        while (true) {
            try {
                String entrada = InOut.leString("Digite a data de nascimento (AAAA-MM-DD): ");
                this.dataNascimento = java.sql.Date.valueOf(entrada);
                break; // sai do loop se der certo
            } catch (IllegalArgumentException e) {
            System.out.println("Data inválida! Use o formato AAAA-MM-DD.");
            }
        }

        InOut.MsgDeInformacao("Cadastro", "Jogador cadastrado com sucesso!");
        return true;
    }
    
     public void criarAposta (GerenciadorSistema sistema){

        double valor = InOut.leDouble("Digite o valor da aposta:");

        if (valor <= 0) {
            InOut.MsgDeErro("Erro", "Valor inválido!");
            return;
        }

        if (valor > credito.consultarSaldo()) {
            InOut.MsgDeErro("Erro", "Saldo insuficiente!");
            return;
        }

        Aposta aposta = new Aposta();
        aposta.definirValor(valor); 
        aposta.realizarAposta(sistema);

      
        credito.sacar(valor);
        apostas.add(aposta);

        InOut.MsgDeInformacao("Sucesso", "Aposta criada!");
    }
    
     public void cancelarAposta() {

        if (apostas.isEmpty()) {
            InOut.MsgDeErro("Erro", "Não há apostas!");
            return;
        }

        int index = InOut.leInt("Digite o índice da aposta (0 a " + (apostas.size() - 1) + "):");

        if (index < 0 || index >= apostas.size()) {
            InOut.MsgDeErro("Erro", "Índice inválido!");
            return;
        }

        Aposta aposta = apostas.remove(index);
        credito.depositar(aposta.getValor());

        InOut.MsgDeInformacao("Cancelado", "Aposta cancelada e valor devolvido!");
    }
    
    public void menu(GerenciadorSistema sistema) {

        int opcao;

        do {
            System.out.println("\n===== SISTEMA BET =====");
            System.out.println("1 - Adicionar crédito");
            System.out.println("2 - Sacar crédito");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Criar aposta");
            System.out.println("5 - Listar apostas");
            System.out.println("6 - Cancelar aposta");
            System.out.println("7 - Verificar resultados");
            System.out.println("0 - Sair");

            opcao = InOut.leInt("Escolha uma opção:");

            switch (opcao) { 

                case 1 -> {
                    double valor = InOut.leDouble("Valor para depósito:");
                    credito.depositar(valor);
                }

                case 2 -> {
                    double valor = InOut.leDouble("Valor para saque:");
                    credito.sacar(valor);
                }

                case 3 -> {
                    InOut.MsgDeInformacao("Saldo", 
                        "Saldo atual: " + credito.consultarSaldo());
                }

                case 5 -> criarAposta(sistema); 

                case 6 -> listarApostas(); 

                case 7 -> cancelarAposta();
                
                case 0 -> InOut.MsgDeInformacao("Saindo", "Até logo!");

                default -> InOut.MsgDeErro("Erro", "Opção inválida!");
            }

        } while (opcao != 0);
    }

    
    public void listarApostas(){
        String mensagem = "Lista de apostas:\n";
        for(int i = 0; i < apostas.size(); i++){
            mensagem += "Aposta " + (i + 1) + ": " + apostas.get(i) + "\n";
        }

        InOut.MsgSemIcone("Apostas", mensagem);
    }
}