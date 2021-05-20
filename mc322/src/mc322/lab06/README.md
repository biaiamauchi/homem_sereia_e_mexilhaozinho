## Arquivos Java do Jogo

> Para o jogo de **lab06**, rode:
> java mc322.lab06.Main data/wumpus.csv
>
> Link para o [lab06](src/mc322/lab06).

> ## Destaques de Arquitetura

> ### `Objeto Herói`
> ~~~java
> public class Heroi extends Componente{
>    private int score;
>    private boolean flechaEquipada;
>    private boolean flechaUsada;
>    private boolean ouroColetado;
>        //...
>    }
> ~~~
> Conforme especificado no laboratório, fizemos com que as classes só tivessem aquilo que lhes fosse respeito. Como exemplo, trouxemos os atributos da Classe Herói, demonstrando que os itens que lhe dizem respeito estão apenas nesta classe, apesar de ser filha da Classe Componente. 

> ### `Herança de Componente`
> ~~~java
> public abstract class Componente{
>    protected String preenchimento;
>    protected int linha;
>    protected int coluna;
>        //...
>    }
> ~~~
> Conforme especificado no laboratório, criamos uma classe abstrata chamada Componente, assim caso o jogo precisasse ser atualizada seria muito simples criar um novo componente, precisando fazer alterações mínimas, sendo elas: a adição de atributos e métodos próprios do novo componente.

> ### `Encapsulamento`
> ~~~java
> public class Controle{
>       //...
>    private boolean verificarTabuleiro(String[][] matrizComandos){...}
>    public void jogar(){...}
>    private void finalizarJogo(){...}
>    private void movimentar(String comando) {...}
>        //...
>    }
> ~~~
> Conforme especificado no laboratório, a classe que instanciar Controle só terá acesso àquilo que é necessário para o bom funcionamento do programa. Por exemplo, a classe Main chama Controle, mas não precisa saber como é feita a verificação do movimento, só precisa acionar o jogo.


