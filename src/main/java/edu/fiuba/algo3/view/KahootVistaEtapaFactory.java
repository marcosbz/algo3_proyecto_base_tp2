/**
 * 
 */
package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.KahootControlador;
import javafx.scene.Node;

/**
 * @author marco
 *
 */
public class KahootVistaEtapaFactory {
	
	private KahootControlador controlador;

	public KahootVistaEtapaFactory(KahootControlador controlador) {
		this.controlador = controlador;
	}

	public Node createEtapa(String tipo) {
		Node vista = null;
		if(tipo == "etapaModeloInicio") {
			vista = new KahootVistaInicio(this.controlador);
		}
		else if(tipo == "etapaModeloInsertarJugadores") {
			vista = new KahootVistaInsertarJugadores(this.controlador);
		}
		else if(tipo == "etapaModeloJuegoPrincipal") {
			vista = new KahootVistaJuegoPrincipal(this.controlador);
		}
		else if(tipo == "etapaModeloMostrarResultados") {
			vista = new KahootVistaMostrarResultados(this.controlador);
		}
		else {
			throw new IllegalArgumentException("Etapa no existe: " + tipo);
		}
		return vista;
	}

}
