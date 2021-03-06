package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.vistasGenerales.VistaMultiplicadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class CargarVistaMultiplicador implements EventHandler<ActionEvent> {

    Kahoot miModelo;
    Stage miStage;

    public CargarVistaMultiplicador(Kahoot modelo, Stage stage){
        miModelo = modelo;
        miStage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        AudioClip sonidoBoton = new AudioClip(this.getClass().getResource("/sonidos/botonClick.mp3").toExternalForm());
        sonidoBoton.setVolume(100);
        sonidoBoton.play();
        VistaMultiplicadores vistaPregunta = new VistaMultiplicadores(miModelo, miStage, miModelo.obtenerPrimerJugador());
        Scene escena = new Scene(vistaPregunta);
        miStage.setScene(escena);
    }
}
