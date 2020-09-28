/**
 * 
 */
package edu.fiuba.algo3.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import edu.fiuba.algo3.controller.KahootControlador;
import edu.fiuba.algo3.controller.KahootControladorRespuestaVOF;
import edu.fiuba.algo3.modelo.Desafio;
import edu.fiuba.algo3.modelo.DesafioVOF;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @author marco
 *
 */
public class KahootVistaDesafioVOF extends StackPane implements PropertyChangeListener {

	private KahootControladorRespuestaVOF controlador;
	private Desafio desafio;
	private BorderPane border;
	private HBox botoneraSeleccion;
	private Label sentencia;
	private Button botonFalso;
	private Button botonVerdadero;
	private Boolean respuesta;
	private Button botonAceptar;

	public KahootVistaDesafioVOF(KahootControlador controlador, Desafio desafio) {
		// TODO Auto-generated constructor stub
		this.controlador = new KahootControladorRespuestaVOF(controlador);
		this.desafio = desafio;
		this.respuesta = null;
		/* Construir la vista con la información del desafio */
		this.border = new BorderPane();
		this.sentencia = new Label(this.desafio.getConsigna());
		this.botoneraSeleccion = new HBox();
		this.botonFalso = new Button("Falso");
		this.botonVerdadero = new Button("Verdadero");
		this.botonAceptar = new Button("Aceptar");
		this.botonFalso.setOnAction((event) -> {
			this.respuesta = false;
			this.botonVerdadero.setStyle("-fx-base:initial;");
			this.botonFalso.setStyle("-fx-background-color: #ff0000;");
		});
		this.botonVerdadero.setOnAction((event) -> {
			this.respuesta = true;
			this.botonFalso.setStyle("-fx-base:initial;");
			this.botonVerdadero.setStyle("-fx-background-color: #00ff00;");
		});
		this.botonAceptar.setOnAction((event) -> {
			this.controlador.tomarRespuesta(this);
		});;
		this.botoneraSeleccion.getChildren().addAll(this.botonVerdadero, this.botonFalso);
		this.border.setTop(this.sentencia);
		this.border.setCenter(this.botoneraSeleccion);
		this.border.setBottom(this.botonAceptar);
		this.getChildren().clear();
		this.getChildren().add(this.border);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

	public boolean getValorUsuario() {
		// TODO Auto-generated method stub
		return this.respuesta;
	}

}
