package edu.fiuba.algo3.view.vistasGenerales;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.eventos.PonerVistaIngresarUsuarios;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaMenu extends StackPane {

    private Button jugarBoton;
    StackPane stack;

    public VistaMenu(Kahoot modelo, Stage stage) {
        this.obtenerMenuInicio(modelo, stage);
        this.obtenerColorDeFondo();
        this.getChildren().addAll(stack);
    }

    private void obtenerMenuInicio(Kahoot modelo, Stage stage){
        this.getChildren().clear();

        jugarBoton = new Button("Iniciar");
        Label titulo = new Label("Bienvenido a Cajoot");
        titulo.setFont(new Font(50));
        jugarBoton.setOnAction(new PonerVistaIngresarUsuarios(modelo, stage));
        stack = new StackPane();
        stack.getChildren().addAll(titulo, jugarBoton);
        stack.setMargin(titulo, new Insets(-200, -10, 0, 30));
    }

    private void obtenerColorDeFondo() {
        Color color = Color.rgb(122,62,72);
        stack.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}