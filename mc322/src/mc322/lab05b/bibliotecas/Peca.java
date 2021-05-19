package mc322.lab05b.bibliotecas;

public abstract class Peca {
    protected int posicaoLinha;
    protected int posicaoColuna;
    protected String cor;

    public Peca(int posicaoLinha, int posicaoColuna, String cor){
        this.posicaoColuna = posicaoColuna;
        this.posicaoLinha = posicaoLinha;
        this.cor = cor;
    }

    protected abstract boolean movimento(String[] tabuleiro, int linhaFinal, int colunaFinal);

    public String getCor() {
        return this.cor;
    }

    public int getPosicaoLinha() {
        return this.posicaoLinha;
    }

    public int getPosicaoColuna() {
        return this.posicaoColuna;
    }
}
