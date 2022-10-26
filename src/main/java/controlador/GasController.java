package controlador;

import surtidores.Coche;
import surtidores.DependienteGasolinera;
import surtidores.Surtidor;

public class GasController {

    public void Principal(){
        Surtidor[] surtidor = new Surtidor[4];
        Coche[] coche = new Coche[50];
        DependienteGasolinera dependiente = new DependienteGasolinera();

        for (int i = 0; i < surtidor.length ; i++) {
            surtidor[i] = new Surtidor(i);
        }

        for (int i = 0; i < coche.length; i++) {
            coche[i] = new Coche(i, surtidor[i], dependiente);
        }

        for (int i = 0; i < coche.length ; i++) {
            coche[i].run();
        }
    }
}
