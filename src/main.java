void main() {
    
    GerenciadorSistema sistema = new GerenciadorSistema();
    
    Jogador jogador = new Jogador();
    jogador.cadastrar();
    jogador.menu();
    
    Credito conta = new Credito();
    System.out.println("Saldo: " + conta.consultarSaldo());
    
}
