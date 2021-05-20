package mc322.lab06.componentes;

public abstract class Componente {
    protected String preenchimento;
    protected int linha;
    protected int coluna;

    public Componente(String preenchimento, int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
        this.preenchimento = preenchimento;
    }

    public String getPreenchimento(){
        return preenchimento;
    }

    public int getLinha(){
        return linha;
    }

    public int getColuna(){
        return coluna;
    }

    public void setLinha(int linha){
        this.linha = linha;
    }

    public void setColuna(int coluna){
        this.coluna = coluna;
    }

    public void setPreenchimento(String preenchimento){
        this.preenchimento = preenchimento;
    }
}
