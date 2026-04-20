
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alicefingiro
 */
public class Aposta {

    private int idAposta;
    private double valorAposta;
    
    private ArrayList<Aposta> apostas = new ArrayList<>();
    private Jogador jogador = new Jogador ();
    
    public Aposta() {
    }

    
    public Aposta(int idAposta, double valorAposta, int repetir) {
        this.idAposta = idAposta;
        this.valorAposta = valorAposta;
    }
    
    
    
    public void definirValor(double valor) {
        this.valorAposta = valor;
    }

    public double getValor() {
        return valorAposta;
    }

    public void realizarAposta() {
        System.out.println("Aposta realizada: " + valorAposta);
    }
    
    public void criarAposta (){

        double valor = InOut.leDouble("Digite o valor da aposta:");

        if (valor <= 0) {
            InOut.MsgDeErro("Erro", "Valor inválido!");
            return;
        }

        if (valor > jogador.getSaldo()) {
            InOut.MsgDeErro("Erro", "Saldo insuficiente!");
            return;
        }

        Aposta aposta = new Aposta();
        aposta.definirValor(valor);
        aposta.realizarAposta();

      
        jogador.sacarSaldo(valor);
        
        
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
        jogador.DepositarSaldo(aposta.getValor());

        InOut.MsgDeInformacao("Cancelado", "Aposta cancelada e valor devolvido!");
    }
    
    public void listarApostas(){
        String mensagem = "Lista de apostas:\n";
        for(int i = 0; i < apostas.size(); i++){
            mensagem += "Aposta " + (i + 1) + ": " + apostas.get(i) + "\n";
        }

        InOut.MsgSemIcone("Apostas", mensagem);
    }
    
    
}
