package mc322.lab06;

import mc322.lab06.bibliotecas.Controle;

public class Main {
    public static void main(String[] args) {
        Controle jogo = new Controle();
        if(jogo.construirTabueiro(args[0]))
            jogo.jogar();
    }
}
