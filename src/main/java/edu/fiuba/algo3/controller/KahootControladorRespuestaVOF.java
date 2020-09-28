/**
 * 
 */
package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.RespuestaDesafio;
import edu.fiuba.algo3.modelo.RespuestaVOF;
import edu.fiuba.algo3.view.KahootVistaDesafioVOF;

/**
 * @author marco
 *
 */
public class KahootControladorRespuestaVOF {

	private KahootControlador controladorPrincipal;

	public KahootControladorRespuestaVOF(KahootControlador controlador) {
		// TODO Auto-generated constructor stub
		this.controladorPrincipal = controlador;
	}

	public void tomarRespuesta(KahootVistaDesafioVOF kahootVistaDesafioVOF) {
		// TODO Auto-generated method stub
		/* Le pido a la vista el valor de respuesta del usuario, creo la estructura de la respuesta y se la envio al controlador principal */
		RespuestaDesafio respuestaVOF = new RespuestaVOF(kahootVistaDesafioVOF.getValorUsuario());
		this.controladorPrincipal.enviarRespuesta(respuestaVOF);
	}

}
