package surtidores;

import java.util.Random;

public class Coche extends Thread{

    private Random random = new Random();
    private int id;
    private Surtidor surtidor;
    public static boolean tanqueLleno = false;

    public Coche(int id, Surtidor surtidor){
        this.id = id;
        this.surtidor = surtidor;
    }


    @Override
    public void run() {
        while(true){

        }
    }
}
