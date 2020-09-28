/**
 * 
 */
package edu.fiuba.algo3.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import edu.fiuba.algo3.controller.KahootControlador;
import edu.fiuba.algo3.modelo.Desafio;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.KahootModelo;
import edu.fiuba.algo3.view.Excepciones.VistaDeDesafioNoImplementadaException;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @author marco
 *
 */
public class KahootVistaJuegoPrincipal extends StackPane implements PropertyChangeListener {

	KahootVistaEscenaDesafioFactory escenaFactory;
	Label labelNombreJugador;

	public KahootVistaJuegoPrincipal(KahootControlador controlador) {
		// TODO Auto-generated constructor stub
		this.escenaFactory = new KahootVistaEscenaDesafioFactory(controlador);
		this.labelNombreJugador = new Label();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getPropertyName() == "KahootNuevoDesafio") {
			Desafio desafioActual = (Desafio) evt.getNewValue();
			try {
				var escenaActual = (StackPane) this.escenaFactory.createEscena(desafioActual);
				var modeloObservable = (KahootModelo) evt.getSource();
				modeloObservable.addObserver((PropertyChangeListener) escenaActual); /* FIXME: No parece muy prolijo */
				this.getChildren().clear();
				var setupView = new VBox();
				setupView.getChildren().addAll(this.labelNombreJugador, escenaActual);
				this.getChildren().add(setupView);
			} catch (VistaDeDesafioNoImplementadaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(evt.getPropertyName() == "KahootSiguienteJugador") {
			Jugador jugadorActualModelo = (Jugador) evt.getNewValue();
			this.labelNombreJugador.setText(jugadorActualModelo.getNombre());
		}
	}

}
