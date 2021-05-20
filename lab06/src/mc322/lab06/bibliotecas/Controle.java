package mc322.lab06.bibliotecas;

import mc322.lab06.componentes.Heroi;

import java.util.Random;
import java.util.Scanner;

public class Controle {
    private boolean isJogoFinalizado;
    private Montador montador;
    private Heroi player = new Heroi("P", 0, 0);
    private int linhaNovaHeroi, colunaNovaHeroi;
    private String mensagemFinalizacao = "";
    private String nomePlayer;

    public Controle(){
        montador = new Montador();
    }

    public boolean construirTabueiro(String caminhoCSV){ //constrói o tabuleiro
        CSVHandling posicoes = new CSVHandling();
        posicoes.setDataSource(caminhoCSV);
        String matrizComandos[][] = posicoes.requestCommands(); //retorno = [[1:1, P], [1:2, _], ...,[4:4, _]];
        if (verificarTabuleiro(matrizComandos)){
            montador.montaTabuleiro(matrizComandos);
            linhaNovaHeroi = colunaNovaHeroi = 0;
            return true;
        }
        return false;
    }

    private boolean verificarTabuleiro(String[][] matrizComandos){ //verificar se a entrada forma um tabuleiro válido
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

    public void jogar(){
        System.out.print("Qual o nome do player? ");
        Scanner teclado = new Scanner(System.in);
        nomePlayer = teclado.next();
        String comando = "";

        while(!getIsJogoFinalizado()){
            mostrarCaverna();

            comando = teclado.next();

            movimentar(comando);
            finalizarJogo();
        }
        mostrarCaverna();
    }

    private void finalizarJogo(){ //se herói voltou com o ouro para o começo do jogo
        if(player.getLinha() == 0 && player.getColuna() == 0 && player.getOuroColetado()){
            setIsJogoFinalizado(true);
            player.addScore(1000);
            mensagemFinalizacao = "Você ganhou =D !!! Ouro capturado e levado para fora da caverna!";
        }
    }

    private void movimentar(String comando){
        boolean movimento;

        if(comando.equals("w") || comando.equals("s") || comando.equals("d") || comando.equals("a")){
            movimento = verificaMovimento(comando);
            if(movimento){
                player.addScore(-15);

                if(montador.getCaverna().getCelulaCaverna(linhaNovaHeroi, colunaNovaHeroi).getPreenchimento() == "B"){
                    setIsJogoFinalizado(true);
                    player.addScore(-1000);
                    mensagemFinalizacao = "Você perdeu =(, pois caiu no Buraco";
                }
                else if(montador.getCaverna().getCelulaCaverna(linhaNovaHeroi, colunaNovaHeroi).getPreenchimento() == "W"){
                    if(player.getFlechaEquipada()){
                        Random matarWumpus = new Random();
                        if(matarWumpus.nextBoolean()){
                            player.addScore(500);
                            player.setFlechaUsada(true);
                            player.setWumpusMorto(true);
                            montador.arrumarCavernaWumpusMorto(linhaNovaHeroi, colunaNovaHeroi);
                        }
                        else{
                            setIsJogoFinalizado(true);
                            player.addScore(-1000);
                            mensagemFinalizacao = "Você perdeu =(, pois foi morto pelo Wumpus";
                        }
                        player.setFlechaEquipada(false);
                        player.addScore(-100);
                    }
                    else{
                        setIsJogoFinalizado(true);
                        player.addScore(-1000);
                        mensagemFinalizacao = "Você perdeu =(, pois foi morto pelo Wumpus";
                    }
                }
                player.setColuna(colunaNovaHeroi);
                player.setLinha(linhaNovaHeroi);
                montador.getCaverna().getSala(player.getLinha(), player.getColuna()).setSalaVisitada(true);
            }
        }
        else if(comando.equals("k")) {
            if (player.getFlechaUsada() == false && player.getFlechaEquipada() == false)
                player.setFlechaEquipada(true);
        }

        else if(comando.equals("c") && montador.getCaverna().getCelulaCaverna(player.getLinha(), player.getColuna()).getPreenchimento() == "O")
            player.setOuroColetado(true);

        else if(comando.equals("q")){
            setIsJogoFinalizado(true);
            mensagemFinalizacao = "Volte sempre !";
        }
    }

    private boolean verificaMovimento(String comando) {
        switch (comando) {
            case "w":
                //sala acima
                if(player.getLinha() - 1 >= 0) {
                    linhaNovaHeroi = player.getLinha() - 1;
                    return true;
                }
                break;
            case "s":
                //sala abaixo
                if(player.getLinha() + 1 < 4){
                    linhaNovaHeroi = player.getLinha() + 1;
                    return true;
                }
                break;
            case "d":
                //sala direita
                if(player.getColuna() + 1 < 4){
                    colunaNovaHeroi = player.getColuna() + 1;
                    return true;
                }
                break;
            case "a":
                //sala esquerda
                if(player.getColuna() - 1 >= 0){
                    colunaNovaHeroi = player.getColuna() - 1;
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean getIsJogoFinalizado(){
        return this.isJogoFinalizado;
    }

    public void setIsJogoFinalizado(boolean isJogoFinalizado){
        this.isJogoFinalizado = isJogoFinalizado;
    }

    private void mostrarCaverna(){
        System.out.println("****************************************");

        for(int i = 0; i < 4; i++){
            System.out.print(i+1+" ");
            for(int j = 0; j < 4; j++){
                if(i == player.getLinha() && j == player.getColuna()){
                    if(montador.getCaverna().getSala(i, j).getComponente().getPreenchimento() == "O" && player.getOuroColetado())
                        System.out.print("P");
                    else if(montador.getCaverna().getSala(i, j).getComponente().getPreenchimento() == "O" && !player.getOuroColetado())
                        System.out.print("O");
                    else if(montador.getCaverna().getSala(i, j).getComponente().getPreenchimento() == "W" && isJogoFinalizado)
                        System.out.print("W");
                    else if(montador.getCaverna().getSala(i, j).getComponente().getPreenchimento() == "B")
                        System.out.print("B");
                    else
                        System.out.print("P");

                }
                else {
                    if (montador.getCaverna().getSala(i, j).getComponente().getPreenchimento() != "P") {
                        if (!montador.getCaverna().getSala(i, j).getSalaVisitada())
                            System.out.print("-");
                        else if (montador.getCaverna().getSala(i, j).getSalaVisitada() && montador.getCaverna().getSala(i, j).getComponente().getPreenchimento() == "_")
                            System.out.print("#");
                        else {
                            if(montador.getCaverna().getSala(i, j).getComponente().getPreenchimento() == "O" && player.getOuroColetado())
                                System.out.print("#");
                            else
                                System.out.print(montador.getCaverna().getCelulaCaverna(i, j).getPreenchimento());
                        }
                    } else
                        System.out.print("#");
                }
            }
            System.out.println("");
        }

        System.out.println("  "+1234);
        System.out.println("");
        System.out.println("Player: " + nomePlayer);
        System.out.println("Score: " + player.getScore());
        System.out.println(mensagemFinalizacao);

        if(!isJogoFinalizado){
            if(player.getOuroColetado())
                System.out.println("Ouro capturado");

            if(player.getWumpusMorto())
                System.out.println("Wumpus morto");

            if(player.getFlechaEquipada())
                System.out.println("Flecha equipada");

            if(player.getFlechaUsada())
                System.out.println("Flecha usada");
        }
    }
}
