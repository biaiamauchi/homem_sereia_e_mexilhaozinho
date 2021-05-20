package mc322.lab05b.bibliotecas;
import mc322.lab05b.bibliotecas.CSVHandling;
import mc322.lab05b.bibliotecas.Dama;
import mc322.lab05b.bibliotecas.Peao;
import mc322.lab05b.bibliotecas.Peca;

import java.io.*;

public class Tabuleiro {
    private String tabuleiro[];
    private String situacaoTabuleiro[] = new String[8];
    private Peca tabuleiroPecas[][] = new Peca[8][8];
    private String arquivoEntrada;
    private String arquivoSaida;

    public Tabuleiro(String arquivoEntrada, String arquivoSaida){
        this.arquivoEntrada = arquivoEntrada;
        this.arquivoSaida = arquivoSaida;
    }

    public void executar() { //precisa retornar string
        String tabuleiro[] = {"-p-p-p-p", "p-p-p-p-", "-p-p-p-p", "--------",
                "--------", "b-b-b-b-", "-b-b-b-b", "b-b-b-b-"};
        imprimirTabuleiro(tabuleiro);
        preencherTabuleiro(tabuleiro);

        //chamando comandos
        CSVHandling csv = new CSVHandling();
        csv.setDataSource(this.arquivoEntrada);
        String comandos[] = csv.requestCommands();

        //executando comandos
        for(int i = 0; i < comandos.length; i++) {
            System.out.println("Comando: " + comandos[i]);
            solicitaMovimento(tabuleiro, tabuleiroPecas, comandos[i]);
        }
    }

    public void solicitaMovimento(String[] tabuleiro, Peca[][] tabuleiroPecas, String comando) {
        int linhaInicial = 56 - (int)comando.charAt(1);
        int colunaInicial = (int)comando.charAt(0) - 97;
        int linhaFinal = 56 - (int)comando.charAt(4);
        int colunaFinal = (int)comando.charAt(3) - 97;
        boolean movimentar;

        if(tabuleiroPecas[linhaInicial][colunaInicial] != null) {
            movimentar = tabuleiroPecas[linhaInicial][colunaInicial].movimento(tabuleiro, linhaFinal, colunaFinal);
            if (movimentar) {

                tabuleiro[linhaInicial] = tabuleiro[linhaInicial].substring(0, colunaInicial)+"-"+tabuleiro[linhaInicial].substring(colunaInicial+1);

                int i = 0;
                if(linhaFinal - linhaInicial < 0)
                    i = -1;
                else
                    i=1;

                if (tabuleiroPecas[linhaInicial][colunaInicial] instanceof Peao) {
                    if(colunaFinal - colunaInicial == -2) {
                        tabuleiro[linhaInicial+i] = tabuleiro[linhaInicial+i].substring(0, colunaInicial-1)+"-"+tabuleiro[linhaInicial+i].substring(colunaInicial);
                    }
                    else if(colunaFinal - colunaInicial == 2){
                        tabuleiro[linhaInicial+i] = tabuleiro[linhaInicial+i].substring(0, colunaInicial+1)+"-"+tabuleiro[linhaInicial+i].substring(colunaInicial+2);
                    }

                    if(tabuleiroPecas[linhaInicial][colunaInicial].getCor() == "p" && linhaFinal == 7)
                        tabuleiro[linhaFinal] = tabuleiro[linhaFinal].substring(0, colunaFinal)+"P"+tabuleiro[linhaFinal].substring(colunaFinal+1);
                    else if(tabuleiroPecas[linhaInicial][colunaInicial].getCor() == "b" && linhaFinal == 0)
                        tabuleiro[linhaFinal] = tabuleiro[linhaFinal].substring(0, colunaFinal)+"B"+tabuleiro[linhaFinal].substring(colunaFinal+1);
                    else
                        tabuleiro[linhaFinal] = tabuleiro[linhaFinal].substring(0, colunaFinal)+tabuleiroPecas[linhaInicial][colunaInicial].getCor()+tabuleiro[linhaFinal].substring(colunaFinal+1);

                } else {
                    if(Math.abs(colunaFinal - colunaInicial) <= 2) {
                        if(colunaFinal - colunaInicial == -2) {
                            tabuleiro[linhaInicial+i] = tabuleiro[linhaInicial+i].substring(0, colunaInicial-1)+"-"+tabuleiro[linhaInicial+i].substring(colunaInicial);
                        }
                        else if(colunaFinal - colunaInicial == 2){
                            tabuleiro[linhaInicial+i] = tabuleiro[linhaInicial+i].substring(0, colunaInicial+1)+"-"+tabuleiro[linhaInicial+i].substring(colunaInicial+2);
                        }
                    }

                    tabuleiro[linhaFinal] = tabuleiro[linhaFinal].substring(0, colunaFinal)+tabuleiroPecas[linhaInicial][colunaInicial].getCor()+tabuleiro[linhaFinal].substring(colunaFinal+1);
                }

                preencherTabuleiro(tabuleiro);
                imprimirTabuleiro(tabuleiro);
            }
            else{
                System.out.println("Movimento inválido!");
                exportarArquivo(false);
            }
        }
    }

    public void inicializarSituacaoTabuleiro(){
        for(int i = 0; i < 8; i++){
            this.situacaoTabuleiro[i] = "";
        }
    }

    public void imprimirTabuleiro(String[] tabuleiro) {
        inicializarSituacaoTabuleiro();
        for(int i = 0, linha = 8; i < tabuleiro.length; i++, linha--) {
            System.out.println(linha + " " + tabuleiro[i]);
            for(int j = 0; j < 8; j++) {
                char coluna = (char) (97 + j);
                this.situacaoTabuleiro[i] += Character.toString(coluna);
                this.situacaoTabuleiro[i] += ""+(i+1);

                if(tabuleiro[i].charAt(j) == '-')
                    this.situacaoTabuleiro[i] += "_";
                else
                    this.situacaoTabuleiro[i] += Character.toString(tabuleiro[i].charAt(j));
                this.situacaoTabuleiro[i] += "\n";
            }
        }
        System.out.println("  abcdefgh");

        exportarArquivo(true);
    }

    public void exportarArquivo(boolean mensagem) {
        File file = new File(this.arquivoSaida);
        file.delete();

        File arquivo = new File(this.arquivoSaida);
        try {
            boolean statusArq = arquivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CSVHandling csv = new CSVHandling();
        csv.setDataExport(this.arquivoSaida);

        if(mensagem)
            csv.exportState(situacaoTabuleiro);
        else{
            String erro[] = {"erro"};
            csv.exportState(erro);
        }
    }

    public void preencherTabuleiro(String[] tabuleiro) {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                switch(tabuleiro[i].charAt(j)) {
                    case 'p':
                        this.tabuleiroPecas[i][j] = new Peao(i, j, "p");
                        break;
                    case 'b':
                        this.tabuleiroPecas[i][j] = new Peao(i, j, "b");
                        break;
                    case 'P':
                        this.tabuleiroPecas[i][j] = new Dama(i, j, "P");
                        break;
                    case 'B':
                        this.tabuleiroPecas[i][j] = new Dama(i, j, "B");
                        break;
                    default:
                        this.tabuleiroPecas[i][j] = null;
                        break;
                }
            }
        }
    }
}
