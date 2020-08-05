package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VistaIngresarUsuarios extends StackPane {

    public VistaIngresarUsuarios(Kahoot modelo, Stage stage){
        this.getChildren().clear();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label usuarioUno = new Label("Ingrese el nombre del jugador 1");
        grid.add(usuarioUno,3,1);
        TextField textoParaUsuarioUno = new TextField();
        grid.add(textoParaUsuarioUno,4,1);
        Label usuarioDos = new Label("Ingrese el nombre del jugador 2");
        grid.add(usuarioDos,3,2);
        TextField textoParaUsuarioDos = new TextField();
        grid.add(textoParaUsuarioDos,4,2);
        Button jugarBoton = new Button("Jugar");
        jugarBoton.setOnAction(new EventHandler<>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                Scene escenaPregunta = new Scene(new VistaPregunta(modelo));
                stage.setScene(escenaPregunta);
            }
        });
        grid.add(jugarBoton,4,3);
        this.getChildren().addAll(grid);
    }
}