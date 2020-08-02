package edu.fiuba.algo3.modelo.general;

public class Exclusividad implements IModificador {
    private int usosDisponibles;

    public Exclusividad(int cantUsos){
        usosDisponibles = cantUsos;
    }

    @Override
    public int obtenerCantidad(){
        return usosDisponibles;
    }

    @Override
    public Boolean quedanUsos(){
        return (usosDisponibles !=0);
    }

    @Override
    public void utilizar() throws NoQuedanUsosExcepcion {
        if (usosDisponibles > 0) {
            usosDisponibles--;
        }
        else {
            throw new NoQuedanUsosExcepcion("No le quedan usos a la exclusividad.");
        }
    }
    public int modificarPuntaje(int puntaje) throws NoQuedanUsosExcepcion {
        this.utilizar();
        return puntaje * 2;
    }
}
