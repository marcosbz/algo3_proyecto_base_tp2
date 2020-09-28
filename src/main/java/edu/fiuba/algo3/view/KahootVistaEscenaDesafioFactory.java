/**
 * 
 */
package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.KahootControlador;
import edu.fiuba.algo3.modelo.Desafio;
import edu.fiuba.algo3.modelo.DesafioChoice;
import edu.fiuba.algo3.modelo.DesafioVOF;
import edu.fiuba.algo3.view.Excepciones.VistaDeDesafioNoImplementadaException;
import javafx.scene.Node;

/**
 * @author marco
 *
 */
public class KahootVistaEscenaDesafioFactory {

	private KahootControlador controlador;

	public KahootVistaEscenaDesafioFactory(KahootControlador controlador) {
		// TODO Auto-generated constructor stub
		this.controlador = controlador;
	}

	public Node createEscena(Desafio desafio) throws VistaDeDesafioNoImplementadaException {
		// TODO Auto-generated method stub
		if(desafio instanceof DesafioVOF) {
			return new KahootVistaDesafioVOF(this.controlador, desafio);
		}
		else if(desafio instanceof DesafioChoice) {
			return new KahootVistaDesafioMultipleChoice(this.controlador, desafio);
		}
		else {
			throw new VistaDeDesafioNoImplementadaException();
		}
	}

}
