package mc322.lab06.bibliotecas;

import mc322.lab06.componentes.*;

public class Montador {
    //instancia os componentes contidos no arquivo de leitura
    private Caverna caverna;

    public Montador(){
        caverna = new Caverna();
    }

    public Caverna getCaverna(){
        return this.caverna;
    }

    public void montaTabuleiro(String[][] matrizComandos){
        for (int i = 0; i < 16; i++){
            int linha = i / 4;
            int coluna = i % 4;
            if (matrizComandos[i][1].equals("W")) {
                caverna.setCelulaCaverna(new Wumpus("W", linha, coluna), linha, coluna);
            } else if (matrizComandos[i][1].equals("B")){
                caverna.setCelulaCaverna(new Buraco("B", linha, coluna), linha, coluna);
            } else if (matrizComandos[i][1].equals("O")){
                caverna.setCelulaCaverna(new Ouro("O", linha, coluna), linha, coluna);
            } else if (matrizComandos[i][1].equals("P")) {
                caverna.setCelulaCaverna(new Heroi("P", linha, coluna), linha, coluna);
            } else if (matrizComandos[i][1].equals("_")){
                caverna.setCelulaCaverna(new Vazio("_", linha, coluna), linha, coluna);
            }
        }
        verificaBrisaFedor(caverna);
    }

    public void verificaBrisaFedor(Caverna caverna){
        // chamar sempre que o monstro for derrotado ou que o ouro for coletado
        for (int linha = 0; linha < 4; linha++){
            for (int coluna = 0; coluna < 4; coluna++) {
                if (caverna.getCelulaCaverna(linha, coluna).getPreenchimento() == "W") {
                    if (linha + 1 < 4) {
                        if (caverna.getCelulaCaverna(linha + 1, coluna).getPreenchimento() == "_")
                            caverna.setCelulaCaverna(new Fedor("f", linha + 1, coluna), linha + 1, coluna);
                    }

                    if(coluna + 1 < 4) {
                        if (caverna.getCelulaCaverna(linha, coluna + 1).getPreenchimento() == "_")
                            caverna.setCelulaCaverna(new Fedor("f", linha, coluna + 1), linha, coluna + 1);
                    }

                    if(linha - 1 >= 0) {
                        if (caverna.getCelulaCaverna(linha - 1, coluna).getPreenchimento() == "_")
                            caverna.setCelulaCaverna(new Fedor("f", linha - 1, coluna), linha - 1, coluna);
                    }

                    if(coluna - 1 >= 0) {
                        if (caverna.getCelulaCaverna(linha, coluna - 1).getPreenchimento() == "_")
                            caverna.setCelulaCaverna(new Fedor("f", linha, coluna - 1), linha, coluna - 1);
                    }

                } else if (caverna.getCelulaCaverna(linha, coluna).getPreenchimento() == "B") {
                    if (linha + 1 < 4) {
                        if (caverna.getCelulaCaverna(linha + 1, coluna).getPreenchimento() == "_")
                            caverna.setCelulaCaverna(new Brisa("b", linha + 1, coluna), linha + 1, coluna);
                    }

                    if (coluna + 1 < 4) {
                        if (caverna.getCelulaCaverna(linha, coluna + 1).getPreenchimento() == "_")
                            caverna.setCelulaCaverna(new Brisa("b", linha, coluna + 1), linha, coluna + 1);
                    }

                    if(linha - 1 >= 0) {
                        if (caverna.getCelulaCaverna(linha - 1, coluna).getPreenchimento() == "_")
                            caverna.setCelulaCaverna(new Brisa("b", linha - 1, coluna), linha - 1, coluna);
                    }

                    if(coluna - 1 >= 0) {
                        if (caverna.getCelulaCaverna(linha, coluna - 1).getPreenchimento() == "_")
                            caverna.setCelulaCaverna(new Brisa("b", linha, coluna - 1), linha, coluna - 1);
                    }
                }
            }
        }
    }

    public void arrumarCavernaWumpusMorto(int linha, int coluna){
        caverna.getCelulaCaverna(linha, coluna).setPreenchimento("#");

        if (linha + 1 < 4) {
            if (caverna.getCelulaCaverna(linha + 1, coluna).getPreenchimento() == "f")
                caverna.setCelulaCaverna(new Vazio("#", linha + 1, coluna), linha + 1, coluna);
        }

        if(coluna + 1 < 4) {
            if (caverna.getCelulaCaverna(linha, coluna + 1).getPreenchimento() == "f")
                caverna.setCelulaCaverna(new Vazio("#", linha, coluna + 1), linha, coluna + 1);
        }

        if(linha - 1 >= 0) {
            if (caverna.getCelulaCaverna(linha - 1, coluna).getPreenchimento() == "f")
                caverna.setCelulaCaverna(new Vazio("#", linha - 1, coluna), linha - 1, coluna);
        }

        if(coluna - 1 >= 0){
            if (caverna.getCelulaCaverna(linha, coluna - 1).getPreenchimento() == "f")
                caverna.setCelulaCaverna(new Vazio("#", linha, coluna - 1), linha, coluna - 1);
        }
    }
}
