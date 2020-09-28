/**
 * 
 */
package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.KahootModelo;
import edu.fiuba.algo3.modelo.RespuestaDesafio;

/**
 * @author marco
 *
 */
public class KahootControlador {

	private KahootModelo modelo;

	public KahootControlador(KahootModelo kahootModelo) {
		// TODO Auto-generated constructor stub
		this.modelo = kahootModelo;
	}

	public void iniciar() {
		// TODO Auto-generated method stub
		modelo.iniciar();
	}

	public void agregarJugador(String nombreJugador) {
		// TODO Auto-generated method stub
		this.modelo.agregarJugador(nombreJugador);
	}

	public void comenzarJuego() {
		// TODO Auto-generated method stub
		this.modelo.comenzarJuego();
	}

	public void enviarRespuesta(RespuestaDesafio respuesta) {
		// TODO Auto-generated method stub
		this.modelo.insertarRespuesta(respuesta);
		/* TODO: provisorio, no se especifica un modificador, mando solo la respuesta */
		this.modelo.aceptarJugada();
	}

}
