package surtidores;

public class DependienteGasolinera {
    private int coche = 49;

    public synchronized void atenderCoche(int id_c) throws InterruptedException {
        while(coche==0){
            this.wait();
        }
        System.out.println("El coche " + (id_c+1) + " es el coche " + coche);
        coche--;
    }

    public synchronized void desatenderCoche(int id_c) throws InterruptedException {
        coche++;
        System.out.println("El coche " + (id_c+1) + " ya NO es el coche " + coche);
        this.notify();
    }
}
