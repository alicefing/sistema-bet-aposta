void main() {
    
    GerenciadorSistema sistema = new GerenciadorSistema();
    
    
    //Cria um loop for que roda por toda a lista de times criados dentro da classe DadosTimes :)
    for(Map.Entry<String, List<String>> entry : DadosTimes.getJogadoresTimes().entrySet()){
        //Cria um time com a chave de referência do map como nome
        Time time = new Time(entry.getKey());
        
        //Adiciona o time a lista de times do sistema
        sistema.adcTime(time);
        
        //Adiciona os valores do map(lista de jogadores) a lista de jogadores do time
        sistema.adcJogadoresTime(time, entry.getValue());
    }
    
    //Adiciona todos as partidas da classe DadosPartidas a lista de partidas do sistema
    for(Jogo p : DadosPartidas.getPartidas(sistema)){
        sistema.adcPartida(p);
    }
    
    Background fundo = new Background();
    fundo.gerarBack();
    
    Jogador jogador = new Jogador();
    jogador.cadastrar(); 
    jogador.menu(sistema);
    
    Credito conta = new Credito();
    System.out.println("Saldo: " + conta.consultarSaldo());
}
