void main() {
    
    
    Jogador jogador = new Jogador();
    jogador.cadastrar();
    
    Credito conta = new Credito();
    System.out.println("Saldo: " + conta.consultarSaldo());

    
}
