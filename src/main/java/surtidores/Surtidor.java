package surtidores;


public class Surtidor {

    private int tiempoEspera = (int) (Math.random() * (130-50)+50);
    private int id;
    private boolean libre = true;

    public Surtidor(int id){
        this.id = id;
    }

    public synchronized boolean cogerSurtidor(int id_c) throws InterruptedException {
        while(!libre) {
            this.wait(tiempoEspera);
            return false;
        }
        System.out.println("El coche " + (id_c) + " coge el surtidor " + (id));
        libre = false;
        return true;
    }

    public synchronized void soltarSurtidor(int id_c) throws InterruptedException {
        libre = true;
        System.out.println("El coche " + (id_c) + " suelta el surtidor " + (id));
        this.notify();
    }

}
