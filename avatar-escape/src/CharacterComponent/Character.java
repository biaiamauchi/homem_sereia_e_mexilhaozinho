package CharacterComponent;

public class Character implements iCharacterProperties{
    private String character;
    private int linha;
    private int coluna;

    public Character(String character, int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
        this.character = character;
    }

    public String getCharacter(){
        return character;
    }

    public int getLinha(){
        return linha;
    }

    public int getColuna(){
        return coluna;
    }

    public void setCharacter(String character){
        this.character = character;
    }

    public void setLinha(int linha){
        this.linha = linha;
    }

    public void setColuna(int coluna){
        this.coluna = coluna;
    }
}
