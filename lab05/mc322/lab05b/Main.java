package mc322.lab05b;

import mc322.lab05b.client.AppDama;

public class Main {
    public static void main(String[] args) {
        AppDama jogar = new AppDama();
        jogar.executaJogo(args[0], args[1]);
    }
}
