package surtidores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Coche extends Thread{

    private static Logger logger = LoggerFactory.getLogger(Coche.class);
    private int tiempoEspera = (int) (Math.random() * (130-50)+50);
    private int id;
    private Surtidor surtidor;
    private DependienteGasolinera dependiente;
    public static boolean tanqueLleno = false;

    public Coche(int id, Surtidor surtidor, DependienteGasolinera dependiente){
        this.id = id;
        this.surtidor = surtidor;
        this.dependiente = dependiente;
    }


    @Override
    public void run() {
        while(true){
            try{
                dependiente.atenderCoche(id);
                surtidor.cogerSurtidor(id);
                if (surtidor.cogerSurtidor(id)) {
                    surtidor.soltarSurtidor(id);
                    dependiente.desatenderCoche(id);
                    try{
                        Coche.sleep(tiempoEspera);
                    }catch (InterruptedException ex){
                        System.out.println("Error: "+ex.getMessage());
                    }
                    continue;
                }
                logger.info("El coche " + id + " está repostando");
                try {
                    sleep(tiempoEspera);
                } catch (InterruptedException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }

                tanqueLleno = true;
                logger.info("El coche " + id + " ha llenado el tanque");
                surtidor.soltarSurtidor(id);
                dependiente.desatenderCoche(id);


                }catch (InterruptedException ex){
                System.out.println("Error: " + ex.getMessage());
            }
            if(tanqueLleno){
                break;
            }
        }
    }
}
