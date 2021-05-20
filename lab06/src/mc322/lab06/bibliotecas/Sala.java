package mc322.lab06.bibliotecas;
import mc322.lab06.componentes.Componente;

public class Sala {
    private Componente componente;
    private boolean salaVisitada;

    public Sala(Componente componente){
        this.componente = componente;
    }

    public Componente getComponente(){
        return componente;
    }

    public void setComponente(Componente componente){
        this.componente = componente;
    }

    public boolean getSalaVisitada(){
        return this.salaVisitada;
    }

    public void setSalaVisitada(boolean salaVisitada){
        this.salaVisitada = salaVisitada;
    }
}
