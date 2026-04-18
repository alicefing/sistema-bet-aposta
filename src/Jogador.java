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

public class Jogador {

    private int idJogador;
    private String nome;
    private String sobrenome;
    private String apelido;
    private String cpf;
    private String nacionalidade;
    private Date dataNascimento;


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

        this.idJogador = InOut.leInt("Digite o ID do jogador:");
        this.nome = InOut.leString("Digite o nome:");
        this.sobrenome = InOut.leString("Digite o sobrenome:");
        this.apelido = InOut.leString("Digite o apelido:");
        this.cpf = InOut.leString("Digite o CPF:");
        this.nacionalidade = InOut.leString("Digite a nacionalidade:");
        this.dataNascimento = java.sql.Date.valueOf(
            InOut.leString("Digite a data de nascimento (AAAA-MM-DD):")
        );

        InOut.MsgDeInformacao("Cadastro", "Jogador cadastrado com sucesso!");
    }
}