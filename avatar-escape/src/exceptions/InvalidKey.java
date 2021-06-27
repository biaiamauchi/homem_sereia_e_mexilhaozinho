package exceptions;

public class InvalidKey extends Exception{
    private static final long serialVersionUID = 7292358893425468203L;

    public InvalidKey(){
        super();
    }

    public InvalidKey(String message){
        super(message);
    }
}
