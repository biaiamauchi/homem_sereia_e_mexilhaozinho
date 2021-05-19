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
    public void ConstruirTabueiro(String caminhoCSV){
        CSVHandling posicoes = new CSVHandling();
        posicoes.setDataSource(caminhoCSV);
        String matrizComandos[][] = posicoes.requestCommands();
        //[[1:1, P], [1:2, _], ...,[4:4, _]];
        if (verificarTabuleiro(matrizComandos)){
            montador.montaTabuleiro(matrizComandos);
        }
    }

    public boolean verificarTabuleiro(String[][] matrizComandos){
        int n_buracos = 0;
        int n_wumpus = 0;
        int n_heroi = 0;
        int n_ouro = 0;
        if (!matrizComandos[0][1].equals("P")){
            return false;
        }
        for (int i = 0; i < 16; i++){
            if (matrizComandos[i][1].equals("P")) {
                n_heroi++;
            } else if (matrizComandos[i][1].equals("W")) {
                n_wumpus++;
            } else if (matrizComandos[i][1].equals("B")){
                n_buracos++;
            } else if (matrizComandos[i][1].equals("O")){
                n_ouro++;
            }
        }
        if ((n_buracos == 3 || n_buracos == 2) && n_heroi == 1 && n_ouro == 1 && n_wumpus == 1){
            return true;
        }
        return false;
    }

    //correto:
        /*
        1:1,P
        1:2,_
        1:3,B
        1:4,_
        2:1,_
        2:2,_
        2:3,O
        2:4,_
        3:1,W
        3:2,_
        3:3,_
        3:4,_
        4:1,_
        4:2,_
        4:3,B
        4:4,_
        */
        /*
        1:1,P
        1:2,_
        1:3,B
        1:4,_
        2:1,_
        2:2,_
        2:3,O
        2:4,_
        3:1,W
        3:2,_
        3:3,_
        3:4,B
        4:1,_
        4:2,_
        4:3,B
        4:4,_
        */
    //n buracos errado:
        /*
        1:1,P
        1:2,_
        1:3,B
        1:4,_
        2:1,B
        2:2,_
        2:3,O
        2:4,_
        3:1,W
        3:2,_
        3:3,_
        3:4,B
        4:1,_
        4:2,_
        4:3,B
        4:4,_
        */
        /*
        1:1,P
        1:2,_
        1:3,_
        1:4,_
        2:1,_
        2:2,_
        2:3,O
        2:4,_
        3:1,W
        3:2,_
        3:3,_
        3:4,_
        4:1,_
        4:2,_
        4:3,B
        4:4,_
        */
    //n herois errado:
        /*
        1:1,P
        1:2,_
        1:3,B
        1:4,_
        2:1,P
        2:2,_
        2:3,O
        2:4,_
        3:1,W
        3:2,_
        3:3,_
        3:4,_
        4:1,_
        4:2,_
        4:3,B
        4:4,_
        */
        /*
        1:1,_
        1:2,_
        1:3,B
        1:4,_
        2:1,_
        2:2,_
        2:3,O
        2:4,_
        3:1,W
        3:2,_
        3:3,_
        3:4,_
        4:1,_
        4:2,_
        4:3,B
        4:4,_
        */
    //heroi fora do 11:
        /*
        1:1,_
        1:2,_
        1:3,B
        1:4,_
        2:1,_
        2:2,_
        2:3,O
        2:4,_
        3:1,W
        3:2,_
        3:3,_
        3:4,P
        4:1,_
        4:2,_
        4:3,B
        4:4,_
        */
    //n monstro errado:
        /*
        1:1,P
        1:2,_
        1:3,B
        1:4,_
        2:1,_
        2:2,_
        2:3,O
        2:4,_
        3:1,_
        3:2,_
        3:3,_
        3:4,_
        4:1,_
        4:2,_
        4:3,B
        4:4,_
        */
        /*
        1:1,P
        1:2,_
        1:3,B
        1:4,_
        2:1,_
        2:2,_
        2:3,O
        2:4,_
        3:1,W
        3:2,_
        3:3,_
        3:4,W
        4:1,_
        4:2,_
        4:3,B
        4:4,_
        */
    //n ouro errado:
        /*
        1:1,P
        1:2,_
        1:3,B
        1:4,_
        2:1,_
        2:2,_
        2:3,_
        2:4,_
        3:1,W
        3:2,_
        3:3,_
        3:4,_
        4:1,_
        4:2,_
        4:3,B
        4:4,_
        */
        /*
        1:1,P
        1:2,_
        1:3,B
        1:4,_
        2:1,_
        2:2,_
        2:3,O
        2:4,_
        3:1,W
        3:2,_
        3:3,_
        3:4,O
        4:1,_
        4:2,_
        4:3,B
        4:4,_
        */
    //cai no buraco
    //enfrenta monstro

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
