package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class RondaExclusividad extends RondaBase {
    private List<Exclusividad> exclusividades;

    public RondaExclusividad(Pregunta pregunta, List<Jugador> jugadores) {
        super(pregunta, jugadores);
    }

    @Override
    public List<String> obtenerModificadores(Jugador jugador) {
        Exclusividad exclusividad = jugador.obtenerExclusividades();
        List<String> exclusividadRestante = new ArrayList<String>();
        if (exclusividad.quedanUsos()){
            exclusividadRestante.add("Exclusividad");
        }
        return exclusividadRestante;
    }

    public void actualizarPuntaje() {
        int cantidadDeGanadores = 0;
        Jugador ganador = null;
        int puntajeRespuesta = 0;
        
        for (Jugador jugador : jugadores){
            var respuestas = respuestasDeJugadores.get(jugador);
            int puntajeActual = this.preguntaActual.calcularPuntaje(respuestas);
            if (puntajeActual > 0){
                cantidadDeGanadores += 1;
                ganador = jugador;
                puntajeRespuesta = puntajeActual;
            }
        }
        
        if (cantidadDeGanadores == 1){
            int puntajeFinal = 0;
            for (Exclusividad exclusividad :exclusividades){
                puntajeFinal += exclusividad.modificarPuntaje(puntajeRespuesta);
            }
            ganador.agregarPuntaje(puntajeFinal);
        }
    }

    @Override
    public void comenzar() {
//      public void comenzar(Panel panel) {

        for (Jugador jugador:jugadores) {
//            this.obtenerPreguntaActual();
//            this.obtenerModificadores(jugador);
//            this.obtenerPosiblesRespuestas();
//            panel.mostrarPreguntaActual()/
//            panel.mostrarModificadores(jugador);
//            panel.mostrarPosiblesRespuestas();

            this.pedirRespuesta(jugador);
        }
        this.actualizarPuntaje();
//        this.obtenerRespuestasCorrectas();
//        panel.mostrarRespuestasCorrectas()
    }
}