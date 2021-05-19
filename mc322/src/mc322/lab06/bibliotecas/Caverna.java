package mc322.lab06.bibliotecas;

import mc322.lab06.componentes.Componente;

public class Caverna {
    private Sala salas[][] = new Sala[4][4];

    public void setCelulaCaverna(Componente componente, int linha, int coluna){
        this.salas[linha][coluna].setComponente(componente);
    }

    public Componente getCelulaCaverna(int linha, int coluna){
        return this.salas[linha][coluna].getComponente();
    }

    public Sala[][] getCaverna(){
        return this.salas;
    }
}
