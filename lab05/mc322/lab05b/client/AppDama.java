package mc322.lab05b.client;

import mc322.lab05b.bibliotecas.Tabuleiro;

public class AppDama {
    public void executaJogo(String arquivoEntrada, String arquivoSaida) {
        Tabuleiro jogo = new Tabuleiro(arquivoEntrada, arquivoSaida);
        jogo.executar();
    }
}
