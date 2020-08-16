package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.eventos.SiguienteRondaOTerminar;
import edu.fiuba.algo3.view.preguntas.VistaVerdaderoYFalso;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.*;

public class VistaRespuestas extends StackPane {
    GridPane grid;

    public VistaRespuestas(Kahoot modelo, Stage stage){
        this.crearGrid();
        List<Jugador> jugadores = actualizarResultadosYOrdenar(modelo);
        this.obtenerNombresConPuntos(jugadores);
        if(modelo.cambiarRonda()){
            Button siguientePregunta = new Button("Siguiente pregunta");
            siguientePregunta.setOnAction(new SiguienteRondaOTerminar(modelo, stage));
            grid.add(siguientePregunta,42,40);
        }
        this.obtenerColorDeFondo();
        this.getChildren().addAll(grid);
    }

    private void crearGrid(){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
    }

    private List<Jugador> actualizarResultadosYOrdenar(Kahoot modelo){
        List<Jugador> jugadores = new ArrayList<>(modelo.obtenerJugadores());
        modelo.actualizarPuntaje();
        jugadores.sort((o1, o2) -> Integer.compare(o2.obtenerPuntaje(), o1.obtenerPuntaje()));
        return jugadores;
    }

    private void obtenerNombresConPuntos(List<Jugador> jugadores){
        int i = 20;
        for(Jugador jugador : jugadores){
            Label usuario = new Label(jugador.obtenerNombre() + "     ->");
            usuario.setFont(Font.font("Arial", FontWeight.BOLD, 35));
            grid.add(usuario,42,i);
            Label puntos = new Label(String.valueOf(jugador.obtenerPuntaje()));
            puntos.setFont(Font.font("Arial", FontWeight.BOLD, 35));
            grid.add(puntos,43,i);
            i++;
        }
    }
    private void obtenerColorDeFondo() {
        Color color = Color.rgb(122,62,72);
        grid.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
