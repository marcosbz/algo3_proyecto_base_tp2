/**
 * 
 */
package edu.fiuba.algo3.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import edu.fiuba.algo3.controller.KahootControlador;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @author marco
 *
 */
public class KahootVistaInsertarJugadores extends StackPane implements PropertyChangeListener {

	private KahootControlador controlador;
	BorderPane border;
	VBox listaJugadoresView;
	HBox hBoxNombre;
	Label jugadorRepetidoLabel;

	public KahootVistaInsertarJugadores(KahootControlador controlador) {
		// TODO Auto-generated constructor stub
		this.controlador = controlador;
		this.border = new BorderPane();
		this.listaJugadoresView = new VBox();
		this.hBoxNombre = new HBox();
		this.jugadorRepetidoLabel = new Label(); this.jugadorRepetidoLabel.setVisible(false);
		this.border.setTop(hBoxNombre);
		this.border.setLeft(listaJugadoresView);
		start();
	}

	private void start() {
		// TODO Auto-generated method stub
		Label indicacionNombre = new Label("Introducir Nombre: ");
		TextField userTextField = new TextField();
		userTextField.setOnMouseClicked((event )-> {
			this.jugadorRepetidoLabel.setVisible(false);
		});
		Button botonAceptarNombre = new Button("Insertar");
		botonAceptarNombre.setOnAction((event) -> {
			this.controlador.agregarJugador(userTextField.getText());
			userTextField.clear();
		});
		Button botonSiguiente = new Button("Comenzar");
		botonSiguiente.setOnAction((event) -> {
			this.controlador.comenzarJuego();
		});
		this.border.setBottom(botonSiguiente);
		this.hBoxNombre.getChildren().addAll(indicacionNombre, userTextField, botonAceptarNombre, jugadorRepetidoLabel);
		this.getChildren().add(this.border);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getPropertyName() == "KahootIncorporaNuevoJugador") {
			List<Jugador> listaJugadores = (List<Jugador>) evt.getNewValue();
			this.listaJugadoresView.getChildren().clear();
			for(Jugador jugador : listaJugadores) {
				this.listaJugadoresView.getChildren().add(new Label(jugador.getNombre()));
			}
		}
		else if(evt.getPropertyName() == "KahootInsertaJugadorRepetido") {
			this.jugadorRepetidoLabel.setText((String) evt.getNewValue() + " ya existe");
			this.jugadorRepetidoLabel.setVisible(true);
		}
		else if(evt.getPropertyName() == "KahootInsertaNombreInvalido") {
			this.jugadorRepetidoLabel.setText((String) evt.getNewValue());
			this.jugadorRepetidoLabel.setVisible(true);
		}
	}

}
