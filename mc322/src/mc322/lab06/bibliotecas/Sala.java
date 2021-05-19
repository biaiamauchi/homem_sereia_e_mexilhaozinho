package mc322.lab06.bibliotecas;
import mc322.lab06.componentes.Componente;

public class Sala {
    private Componente componente;

    public Sala(Componente componente){
        this.componente = componente;
    }

    public Componente getComponente(){
        return componente;
    }

    public void setComponente(Componente componente){
        this.componente = componente;
    }
}
