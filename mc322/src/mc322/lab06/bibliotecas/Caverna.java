package mc322.lab06.bibliotecas;

import mc322.lab06.componentes.Componente;

public class Caverna {
    private Sala salas[][] = new Sala[4][4];

    public Caverna(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                salas[i][j] = new Sala(null);
            }
        }
    }

    public void setCelulaCaverna(Componente componente, int linha, int coluna){
        salas[linha][coluna].setComponente(componente);
    }

    public Componente getCelulaCaverna(int linha, int coluna){
        return salas[linha][coluna].getComponente();
    }

    public Sala getSala(int linha, int coluna){
        return salas[linha][coluna];
    }

    public Sala[][] getCaverna() {
        return salas;
    }
}
