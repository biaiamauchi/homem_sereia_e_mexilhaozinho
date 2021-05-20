package mc322.lab06;

import mc322.lab06.bibliotecas.Controle;

public class Main {
    public static void main(String[] args) {
        Controle jogo = new Controle();
        if(jogo.construirTabueiro("C:\\Users\\pedro\\Desktop\\homem_sereia_e_mexilhaozinho\\mc322\\src\\mc322\\lab06\\data\\wumpus.csv"))
            jogo.jogar();
    }
}
