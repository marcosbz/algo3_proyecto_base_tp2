package edu.fiuba.algo3;

import edu.fiuba.algo3.controller.KahootControlador;
import edu.fiuba.algo3.modelo.KahootModelo;
import edu.fiuba.algo3.view.KahootVista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        
        var kahootModelo = new KahootModelo();
        var kahootControlador = new KahootControlador(kahootModelo);
        var kahootVista = new KahootVista(kahootControlador);
        kahootModelo.addObserver(kahootVista);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}