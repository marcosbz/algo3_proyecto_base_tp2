/**
 * 
 */
package edu.fiuba.algo3.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import edu.fiuba.algo3.controller.KahootControlador;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * @author marco
 *
 */
public class KahootVistaInicio extends StackPane implements PropertyChangeListener {

	private KahootControlador controlador;

	public KahootVistaInicio(KahootControlador controlador) {
		// TODO Auto-generated constructor stub
		this.controlador = controlador;
		var label = new Label("Pantalla de inicio");
		var botonStart = new Button("Comenzar");
		botonStart.setOnAction((event) -> {
			this.controlador.iniciar();
		});
		this.getChildren().add(label);
		this.getChildren().add(botonStart);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

}
