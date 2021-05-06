package mc322.lab05b.bibliotecas;

public class Dama extends Peca {
    public Dama(int posicaoLinha, int posicaoColuna, String cor){
        super(posicaoLinha, posicaoColuna, cor);
    }

    public boolean movimento(String[] tabuleiro, int linhaFinal, int colunaFinal) {
        if(linhaFinal <= 7 && linhaFinal >= 0 && colunaFinal <= 7 && colunaFinal >= 0) { //se o target estiver dentro do tabuleiro
            if((linhaFinal == this.getPosicaoLinha() - 1 || linhaFinal == this.getPosicaoLinha() + 1) && (colunaFinal == this.getPosicaoColuna() - 1 || colunaFinal == this.getPosicaoColuna() + 1) && tabuleiro[linhaFinal].charAt(colunaFinal) == '-') { //se for caminho vazio
                return true;
            }
            else if(linhaFinal == this.getPosicaoLinha() + 2 && (colunaFinal == this.getPosicaoColuna() - 2 || colunaFinal == this.getPosicaoColuna() + 2) && tabuleiro[linhaFinal].charAt(colunaFinal) == '-') {
                if(tabuleiro[linhaFinal-1].charAt(colunaFinal-1) != this.getCor().charAt(0))
                    return true;
            }
            else if(linhaFinal == this.getPosicaoLinha() - 2 && (colunaFinal == this.getPosicaoColuna() - 2 || colunaFinal == this.getPosicaoColuna() + 2) && tabuleiro[linhaFinal].charAt(colunaFinal) == '-') {
                if(tabuleiro[linhaFinal-1].charAt(colunaFinal-1) != this.getCor().charAt(0))
                    return true;
            }
            else if(linhaFinal > this.getPosicaoLinha() + 2 && colunaFinal > this.getPosicaoColuna() + 2 && tabuleiro[linhaFinal].charAt(colunaFinal) == '-') {
                int aux = Math.abs(linhaFinal - this.getPosicaoLinha()), i = 1;
                while(aux != 0) {
                    if(tabuleiro[this.getPosicaoLinha()+i].charAt(this.getPosicaoColuna()+i) != '-')
                        return false;
                    aux--;
                    i++;
                }
                return true;
            }
            else if(linhaFinal < this.getPosicaoLinha() + 2 && colunaFinal < this.getPosicaoColuna() + 2 && tabuleiro[linhaFinal].charAt(colunaFinal) == '-') {
                int aux = Math.abs(linhaFinal - this.getPosicaoLinha()), i = 1;
                while(aux != 0) {
                    if(tabuleiro[this.getPosicaoLinha()-i].charAt(this.getPosicaoColuna()-i) != '-')
                        return false;
                    aux--;
                    i++;
                }
                return true;
            }
        }
        return false;
    }
}
