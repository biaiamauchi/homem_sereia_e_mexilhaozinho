package mc322.lab06.bibliotecas;

import mc322.lab06.componentes.Heroi;

import java.util.Scanner;

public class Controle {
    private boolean isJogoFinalizado;
    private Montador montador;

    public Controle(){
        //construtor
    }

    //Bia - 1 a 3 + montador
    //1 - recebe da main o CSV de entrada

    //2 - verificar se a entrada dá pra fazer um jogo (de 2 a 3 buracos, 1 monstro, 1 ouro, 1 herói em (1,1))

    //3 - chama o montador para começar as construções das salas e caverna

    //Pedro - 4 a 6
    public void movimentar(){
        while(!getIsJogoFinalizado()){
            Scanner teclado = new Scanner(System.in);
            String comando = teclado.next();
            boolean movimentar;

            if(comando == "w" || comando == "s" || comando == "d" || comando == "e"){
                movimentar = movimentar(player, comando);
            }
            else if(comando == "k"){
                //equipa flecha
            }
            else if(comando == "c"){
                //pega ouro
            }
            else if(comando == "q"){
                setIsJogoFinalizado(true);
            }
            else{
                continue;
            }
        }
    }

    private boolean verificaMovimento(Heroi player, String comando) {
        player.addScore(-15);
        switch (comando) {
            case "w":

                //sala acima
                break;
            case "s":
                //sala abaixo
                break;
            case "d":
                //sala direita
                break;
            case "a":
                //sala esquerda
                break;
        }
    }

    //4 - controlar as entradas de movimento (w, s, d, a, k, c, q)

    //5 - se comunica com o heroi para movimentá-lo

    //6 - printar o jogo

    public boolean getIsJogoFinalizado(){
        return this.isJogoFinalizado;
    }

    public void setIsJogoFinalizado(boolean isJogoFinalizado){
        this.isJogoFinalizado = isJogoFinalizado;
    }
}
