package surtidores;

public class DependienteGasolinera {
    private int coche = 5;

    public synchronized void atenderCoche(int id_c) throws InterruptedException {
        while(coche==0){
            this.wait();
        }
        System.out.println("El coche " + (id_c) + " es atendido");
        coche--;
    }

    public synchronized void desatenderCoche(int id_c) throws InterruptedException {
        coche++;
        System.out.println("El coche " + (id_c) + " es desatendido");
        this.notify();
    }
}
