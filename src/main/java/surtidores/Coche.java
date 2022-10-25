package surtidores;

import java.util.Random;

public class Coche extends Thread{

    private Random random = new Random();
    private int id;
    private Surtidor surtidor;
    private DependienteGasolinera coches;
    public static boolean tanqueLleno = false;

    public Coche(int id, Surtidor surtidor){
        this.id = id;
        this.surtidor = surtidor;
    }


    @Override
    public void run() {
        while(true){
            try{
                coches.atenderCoche(id);
                surtidor.cogerSurtidor(id);
                if (!surtidor.cogerSurtidor(id)) {
                    surtidor.soltarSurtidor(id);
                    coches.desatenderCoche(id);
                    try{
                        Coche.sleep(random.nextInt(1000)+100);
                    }catch (InterruptedException ex){
                        System.out.println("Error: "+ex.getMessage());
                    }
                    continue;
                }
            }catch (InterruptedException ex){
                System.out.println("Error: " + ex.getMessage());
            }
            System.out.println("El coche " + (id+1) + "está repostando");
            try {
                sleep(random.nextInt(1000) + 500);
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            surtidor.soltarSurtidor(id);
        }
    }
}
