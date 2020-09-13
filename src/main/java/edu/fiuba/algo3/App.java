package edu.fiuba.algo3;

import edu.fiuba.algo3.controller.KahootControlador;
import edu.fiuba.algo3.modelo.KahootModelo;
import edu.fiuba.algo3.view.KahootVista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        var kahootModelo = new KahootModelo();
        var kahootControlador = new KahootControlador(kahootModelo);
        var kahootVista = new KahootVista(kahootControlador);
        kahootModelo.addObserver(kahootVista);

        var scene = new Scene(kahootVista, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}