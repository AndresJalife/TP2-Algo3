package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.excepciones.NoQuedanUsosExcepcion;

public class Exclusividad implements IModificador {
    private Integer usosDisponibles;

    public Exclusividad(int cantUsos){
        usosDisponibles = cantUsos;
    }

    @Override
    public int obtenerCantidad(){
        return usosDisponibles;
    }

    @Override
    public String obtenerNombre() {
        return ("Exclusividad (Quedan " + usosDisponibles.toString() + ')');
    }

    @Override
    public Boolean quedanUsos(){
        return (usosDisponibles !=0);
    }

    @Override
    public void utilizar() throws NoQuedanUsosExcepcion {
        if (usosDisponibles <= 0) {
            throw new NoQuedanUsosExcepcion("No le quedan usos a la exclusividad.");
        }
        else {
            usosDisponibles--;
        }
    }
    public int modificarPuntaje(int puntaje) {
        return puntaje * 2;
    }
}
