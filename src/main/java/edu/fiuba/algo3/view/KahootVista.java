/**
 * 
 */
package edu.fiuba.algo3.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.controller.KahootControlador;
import edu.fiuba.algo3.modelo.KahootModelo;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * @author marco
 *
 */
public class KahootVista extends StackPane implements PropertyChangeListener {

	private KahootControlador controlador;
	private KahootVistaEtapaFactory etapaFactory;

	public KahootVista(KahootControlador kahootControlador) {
		// TODO Auto-generated constructor stub
		this.controlador = kahootControlador;
		this.etapaFactory = new KahootVistaEtapaFactory(this.controlador);
		this.start();
	}

	private void start() {
		// TODO Auto-generated method stub
		/*
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        */
        this.getChildren().clear();
        this.getChildren().add(new KahootVistaInicio(controlador));
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) { /* https://docs.oracle.com/javase/8/docs/api/java/beans/PropertyChangeEvent.html */
		// TODO Auto-generated method stub
		/* Only listen to model state change event */
		if("KahootModeloEtapa" == evt.getPropertyName()) {
			/* Create corresponding scene and let it handle its events */
			/* Ask a factory to the model? */
			/* Must know which of all the scenes to create. Inicio, ObtenerJugadores */
			var vista = etapaFactory.createEtapa((String)evt.getNewValue());
			var modeloObservable = (KahootModelo) evt.getSource();
			modeloObservable.addObserver((PropertyChangeListener) vista); /* FIXME: No parece muy prolijo */
			this.getChildren().clear();
			this.getChildren().add(vista);
		}
		else if("KahootNoHayDesafios" == evt.getPropertyName()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Ooops, there was an error!");

			alert.showAndWait();
		}

	}

}
